//package org.nexttech.validators.implementation;
//
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.nexttech.validators.interfaces.ValidCNP;
//
//public class ValidCNPValidator implements ConstraintValidator<ValidCNP, String> {
//    @Override
//    public boolean isValid(String cnp, ConstraintValidatorContext context) {
//        return cnp != null && cnp.matches("\\d{13}");
//    }
//}
