package fr.maboite.correction.validator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = CheckCommandeLinePriceValidator.class)
public @interface CheckCommandeLinePrice {
	
	String message() default "Le prix d'une ligne de commande ne peux pas excéder 2999€";
	Class<?>[] groups() default {}; // Ajoutez ce paramètre même s'il n'est pas utilisé
    Class<? extends Payload>[] payload() default {}; // Ajoutez ce paramètre même s'il n'est pas utilisé
    
}
