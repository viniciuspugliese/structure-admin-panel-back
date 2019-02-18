package com.admin.panel.api.dto.annotations.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.admin.panel.api.dto.annotations.Confirmed;

public class ConfirmedValidator implements ConstraintValidator<Confirmed, String> {
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return true;
	}
}
