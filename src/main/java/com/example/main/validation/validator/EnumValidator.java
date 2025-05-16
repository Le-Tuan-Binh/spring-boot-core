package com.example.main.validation.validator;

import com.example.main.validation.annotation.ValidEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EnumValidator implements ConstraintValidator<ValidEnum, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(ValidEnum validEnum) {
        try {
            pattern = Pattern.compile(validEnum.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Matcher matcher = pattern.matcher(value.name());
        return matcher.matches();
    }
}
