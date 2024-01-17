package com.SefaTas.KuaforRandevu.Exception.Validation;

import com.SefaTas.KuaforRandevu.Entity.User;
import com.SefaTas.KuaforRandevu.Repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User inDb = userRepository.findByEmail(value);
        return inDb == null;
    }
}
