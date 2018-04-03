package com.dsi.spring.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PSCodeConstraintValidator implements ConstraintValidator<PSCode, String> {
    public String codePrefix;

    public void initialize(PSCode code) {
        codePrefix = code.value();
    }

    public boolean isValid(String code, ConstraintValidatorContext arg1) {
        boolean result;
        if(code != null) {
            result = code.startsWith(codePrefix);
        } else {
            result = true;
        }
        return result;
    }
}
