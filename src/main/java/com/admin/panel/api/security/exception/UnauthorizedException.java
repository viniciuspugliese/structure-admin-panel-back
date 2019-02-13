package com.admin.panel.api.security.exception;

public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 2086156140974062978L;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }
}
