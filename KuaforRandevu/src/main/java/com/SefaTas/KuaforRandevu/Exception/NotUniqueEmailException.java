package com.SefaTas.KuaforRandevu.Exception;

import com.SefaTas.KuaforRandevu.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import com.SefaTas.KuaforRandevu.Shared.Messages;

import java.util.Collections;
import java.util.Map;

public class NotUniqueEmailException extends RuntimeException{

    @Autowired
    UserRepository userRepository;

    public NotUniqueEmailException(){
        super(Messages.getMessageForLocale("KuaforRandevu.error.validation", LocaleContextHolder.getLocale()));
    }

    public Map<String, String> getValidationErrors(){
        return Collections.singletonMap("email", Messages.getMessageForLocale("KuaforRandevu.constraint.email.notunique", LocaleContextHolder.getLocale()));
    }
}
