package com.admin.panel.api.dto.annotations.validations;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.admin.panel.api.dto.annotations.Exists;
import com.admin.panel.api.dto.annotations.validations.utils.NativeQueryUtil;

public class ExistsValidator implements ConstraintValidator<Exists, String> {
	
	@Autowired
	private NativeQueryUtil nativeQueryUtil;
	
    private String table;
    
    private String collumn;
    
    private String conditions;

	@Override
	public void initialize(Exists exists) {
		table = exists.table();
		collumn = exists.collumn();
		conditions = exists.conditions();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<?> list = nativeQueryUtil.queryBuilder(table, collumn, value, conditions);
		
		return ! list.isEmpty();
	}
}