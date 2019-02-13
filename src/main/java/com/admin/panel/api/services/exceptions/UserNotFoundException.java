package com.admin.panel.api.services.exceptions;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 9034302460335246984L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
