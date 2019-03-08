package com.admin.panel.api.dto.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.admin.panel.api.dto.annotations.validations.BetweenCompareValidator;

@Documented
@Constraint(validatedBy = BetweenCompareValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BetweenCompare {
	
    public String message() default "";

    public String dateFormat() default "";

    public String conditions() default "";
    
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}