package com.springboot.angular.panel.dto.annotations.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot.angular.panel.dto.annotations.Exists;

public class ExistsValidator implements ConstraintValidator<Exists, String> {

    private String message;

    private String table;

    private String collumn;

	@Override
	public void initialize(Exists exists) {
		this.message = exists.message();
		this.table = exists.table();
		this.collumn = exists.collumn();
	}

	@Override
	public boolean isValid(String field, ConstraintValidatorContext cxt) {
		
//		return field != null && field.matches("[0-9]+") && (field.length() > 8)
//				&& (field.length() < 14);
		
		return false;
	}

}