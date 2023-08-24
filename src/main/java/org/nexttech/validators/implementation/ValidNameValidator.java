//package org.nexttech.validators.implementation;
//
//
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.nexttech.validators.interfaces.ValidName;
//
//
//public class ValidNameValidator implements ConstraintValidator<ValidName, String> {
//    @Override
//    public boolean isValid(String name, ConstraintValidatorContext context) {
//        return name != null && name.length() >= 3;
//    }
//}
