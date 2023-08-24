//package org.nexttech.validators.interfaces;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import jakarta.validation.constraints.NotBlank;
//import org.nexttech.validators.implementation.ValidNameValidator;
//
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.RetentionPolicy;
//
//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = ValidNameValidator.class)
//@NotBlank(message = "Name must not be blank")
//public @interface ValidName {
//    String message() default "Invalid Name";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
