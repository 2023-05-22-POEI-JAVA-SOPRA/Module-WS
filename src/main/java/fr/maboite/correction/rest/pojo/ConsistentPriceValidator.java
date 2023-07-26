package fr.maboite.correction.rest.pojo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentPriceValidator 
  implements ConstraintValidator<ConsistentPrice, String[]> {

    public boolean isValid(Object[] value, ConstraintValidatorContext context) {

        if ((!(value[0].equals("Rolex")) || !(value[0].equals("Ferrari")) || !(value[0].equals("Marque repère")))
        		&& Integer.parseInt(value[1])) {
            throw new IllegalArgumentException(
            		"si brand fait partie des valeurs suivantes : ‘Rolex’, ‘Ferrari’, ‘Marque repère’,"
            			    + "alors le prix peut dépasser 500€. Sinon, le prix doit être inférieur à 500€.");
        }

        return false;
    }
  }
