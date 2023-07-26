//package fr.maboite.correction.rest.pojo;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import jakarta.validation.Payload;
//
//@Constraint(validatedBy = ConsistentPriceValidator.class)
//@Target({ METHOD, CONSTRUCTOR })
//@Retention(RUNTIME)
//@Documented
//public @interface ConsistentPrice {
//	
//    String message() default
//    "si brand fait partie des valeurs suivantes : ‘Rolex’, ‘Ferrari’, ‘Marque repère’,"
//    + "alors le prix peut dépasser 500€. Sinon, le prix doit être inférieur à 500€.";
//
//  Class<?>[] groups() default {};
//
//  Class<? extends Payload>[] payload() default {};
//	
//	
//}
//
//@SupportedValidationTarget(ValidationTarget.PARAMETERS)
//public class ConsistentPriceParameterValidator 
//  implements ConstraintValidator<ConsistentPriceParameters, Object[]> {
//
//    public boolean isValid(
//      String value1, Double value2,
//      ConstraintValidatorContext context) {
//
//        if ((!(value1.equals("Rolex")) || !(value1.equals("Ferrari")) || !(value1.equals("Marque repère")))
//        		&& value2>500) {
//            throw new IllegalArgumentException(
//            		"si brand fait partie des valeurs suivantes : ‘Rolex’, ‘Ferrari’, ‘Marque repère’,"
//            			    + "alors le prix peut dépasser 500€. Sinon, le prix doit être inférieur à 500€.");
//        }
//
//        return true;
//    }
//}
