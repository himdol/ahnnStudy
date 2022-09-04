package com.example.springstudy.valid.memo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MemoValidator implements ConstraintValidator<MemoValidationCheck, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
