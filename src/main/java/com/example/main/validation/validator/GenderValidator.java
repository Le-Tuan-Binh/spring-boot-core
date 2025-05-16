package com.example.main.validation.validator;

import com.example.main.enums.Gender;
import com.example.main.validation.annotation.ValidGender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class GenderValidator implements ConstraintValidator<ValidGender, Gender> {
    private Gender[] genders;

    @Override
    public void initialize(ValidGender constraint) {
        this.genders = constraint.anyOf();
    }

    @Override
    public boolean isValid(Gender value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(genders).contains(value);
    }
}