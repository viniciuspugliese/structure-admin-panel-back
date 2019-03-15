package com.admin.panel.api.dto.annotations.validations.utils;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

@Component
public class ReflectionUtil {

	public ReflectionUtil() {
	}
	
	public Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        
        if (! field.isAccessible()) {
        	field.setAccessible(true);
        }
        
        return field.get(object);
    }
}
