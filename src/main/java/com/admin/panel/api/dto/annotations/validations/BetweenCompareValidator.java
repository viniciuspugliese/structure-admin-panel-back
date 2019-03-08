package com.admin.panel.api.dto.annotations.validations;

import java.text.ParseException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.admin.panel.api.dto.annotations.BetweenCompare;
import com.admin.panel.api.lang.Between;

public class BetweenCompareValidator implements ConstraintValidator<BetweenCompare, Between<?>> {

	private String dateFormat;
	
	@Override
	public void initialize(BetweenCompare betweenCompare) {
		dateFormat = betweenCompare.dateFormat();
	}

	@Override
	public boolean isValid(Between<?> between, ConstraintValidatorContext context) {
		try {
			return between.validate(dateFormat);
		} catch (ParseException e) {
			return false;
		}
	}
}
