package fr.maboite.correction.validator;

import java.util.Arrays;

import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.jpa.entity.Articles;
import fr.maboite.correction.jpa.entity.CommandeLine;
import fr.maboite.correction.service.ArticlesService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckCommandeLinePriceValidator implements ConstraintValidator<CheckCommandeLinePrice, CommandeLine> {

    private String[] allowedBrands;

    @Override
    public void initialize(CheckCommandeLinePrice constraintAnnotation) {

    }

    @Override
    public boolean isValid(CommandeLine commandeLine, ConstraintValidatorContext context) {
    	ArticlesService as = new ArticlesService();
        if (commandeLine == null) {
            return true; // Validation will be skipped for null values
        }
        
        Article a = as.getById(commandeLine.getIdArticle());
        
        Double prixCommandeLine = a.getUnitaryPrice() * Double.parseDouble(String.valueOf(commandeLine.getQuantity()));
        
        boolean isPriceValid = prixCommandeLine <= 2999;

        return isPriceValid;
    }
}
