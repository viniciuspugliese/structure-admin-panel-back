package com.admin.panel.api.services.exceptions;

public class ObjectNotFountException extends RuntimeException {
	private static final long serialVersionUID = 5228786827352037258L;

	public ObjectNotFountException() {
        super();
    }

    public ObjectNotFountException(String message) {
        super(message);
    }

    public ObjectNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFountException(Throwable cause) {
        super(cause);
    }
}
