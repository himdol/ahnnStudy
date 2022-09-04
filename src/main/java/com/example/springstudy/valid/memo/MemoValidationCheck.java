package com.example.springstudy.valid.memo;

import javax.validation.Constraint;

@Constraint(validatedBy = MemoValidator.class)
public @interface MemoValidationCheck {
}
