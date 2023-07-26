package fr.maboite.correction.rest.pojo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Constraint(validatedBy = ConsistentPriceValidator.class)
@Target({ METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
@Documented
public @interface ConsistentPrice {
	
    String message() default
    "si brand fait partie des valeurs suivantes : ‘Rolex’, ‘Ferrari’, ‘Marque repère’,"
    + "alors le prix peut dépasser 500€. Sinon, le prix doit être inférieur à 500€.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
	
	
}
