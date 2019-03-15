package com.admin.panel.api.dto.annotations.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.admin.panel.api.dto.annotations.EqualFields;
import com.admin.panel.api.dto.annotations.validations.utils.ReflectionUtil;

public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

	@Autowired
	private ReflectionUtil reflectionUtil;
	
    private String baseField;
    
    private String matchField;
 
	@Override
	public void initialize(EqualFields equalFields) {
        baseField = equalFields.baseField();
        matchField = equalFields.matchField();
	}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		try {
            Object baseFieldValue = reflectionUtil.getFieldValue(object, baseField);
            Object matchFieldValue = reflectionUtil.getFieldValue(object, matchField);
            
            return baseFieldValue != null && baseFieldValue.equals(matchFieldValue);
        } catch (Exception e) {
            return false;
        }
	}
}
