//package org.nexttech.validators.interfaces;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import org.nexttech.validators.implementation.ValidCNPValidator;
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
//@Constraint(validatedBy = ValidCNPValidator.class)
//@NotBlank(message = "CNP must not be blank")
//@Size(max = 13, message = "CNP length must be 13 digits")
//public @interface ValidCNP {
//    String message() default "Invalid CNP";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
