package com.SefaTas.KuaforRandevu.Exception.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "{KuaforRandevu.constraint.email.notunique}";
    Class <?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
