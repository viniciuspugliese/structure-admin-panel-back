package com.admin.panel.api.services.exceptions;

public class InvalidParameterException extends RuntimeException {
	private static final long serialVersionUID = -655328584666908329L;

	private String field;
	
    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParameterException(Throwable cause) {
        super(cause);
    }

    public InvalidParameterException(String field, String message) {
    	super(message);
    	this.field = field;
    }

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
    
    
}
