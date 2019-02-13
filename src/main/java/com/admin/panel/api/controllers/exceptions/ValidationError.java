package com.admin.panel.api.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 5060782070579389809L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		
	}
	
	public ValidationError(Integer status, String error, Long timestamp, String path) {
		super(status, error, timestamp, path);
	}

	public ValidationError(Integer status, String error, Long timestamp, String path, StackTraceElement[] cause) {
		super(status, error, timestamp, path, cause);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldMessage> errors) {
		this.errors = errors;
	}
	
	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
}
