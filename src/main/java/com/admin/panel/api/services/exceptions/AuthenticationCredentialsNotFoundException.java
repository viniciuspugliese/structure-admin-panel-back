package com.admin.panel.api.services.exceptions;

public class AuthenticationCredentialsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3910099253846061514L;

    public AuthenticationCredentialsNotFoundException() {
        super();
    }

    public AuthenticationCredentialsNotFoundException(String message) {
        super(message);
    }

    public AuthenticationCredentialsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationCredentialsNotFoundException(Throwable cause) {
        super(cause);
    }
}
