package com.springboot.angular.panel.dto.annotations.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot.angular.panel.dto.annotations.Unique;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

	@Override
	public void initialize(Unique contactNumber) {
	}

	@Override
	public boolean isValid(String field, ConstraintValidatorContext cxt) {
		
//		return field != null && field.matches("[0-9]+") && (field.length() > 8)
//				&& (field.length() < 14);
		
		return true;
	}

}