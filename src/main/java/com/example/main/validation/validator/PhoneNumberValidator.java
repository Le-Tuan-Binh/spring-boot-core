package com.example.main.validation.validator;

import com.example.main.validation.annotation.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final String[] PHONE_PATTERNS = {
            "^0\\d{9}$", "^\\(0\\d{2}\\) \\d{6,7}$", "^0\\d{2}-\\d{3}-\\d{4}$", "^\\+84\\d{9}$"
    };

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        for (String pattern : PHONE_PATTERNS) {
            if (value.matches(pattern)) {
                return true;
            }
        }
        return false;
    }
}
