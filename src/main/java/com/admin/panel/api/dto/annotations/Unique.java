package com.admin.panel.api.dto.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.admin.panel.api.dto.annotations.validations.UniqueValidator;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
	
    String message() default "";

    String table() default "";

    String collumn() default "";

    String conditions() default "";
    
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default{};
}