package com.admin.panel.api.services.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 5151644512489475509L;

	public DataIntegrityException() {
        super();
    }

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityException(Throwable cause) {
        super(cause);
    }
}
