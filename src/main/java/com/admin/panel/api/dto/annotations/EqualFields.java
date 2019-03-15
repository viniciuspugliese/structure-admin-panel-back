package com.admin.panel.api.dto.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.admin.panel.api.dto.annotations.validations.EqualFieldsValidator;

@Documented
@Constraint(validatedBy = EqualFieldsValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EqualFields {
	
    public String message() default "";

    public String baseField() default "";
 
    public String matchField() default "";
    
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}