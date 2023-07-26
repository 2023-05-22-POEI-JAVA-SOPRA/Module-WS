package fr.maboite.correction.validator;

import java.util.Arrays;

import fr.maboite.correction.jpa.entity.Articles;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckBrandPriceValidator implements ConstraintValidator<CheckBrandPrice, Articles> {

    private String[] allowedBrands;

    @Override
    public void initialize(CheckBrandPrice constraintAnnotation) {
        allowedBrands = constraintAnnotation.allowedBrands();
    }

    @Override
    public boolean isValid(Articles article, ConstraintValidatorContext context) {
        if (article == null || article.getBrand() == null) {
            return true; // Validation will be skipped for null values
        }

        String brand = article.getBrand();
        double price = article.getUnitaryPrice();

        boolean isBrandAllowed = Arrays.asList(allowedBrands).contains(brand);
        boolean isPriceValid = (isBrandAllowed && price > 500) || (!isBrandAllowed && price < 500);

        return isPriceValid;
    }
}
