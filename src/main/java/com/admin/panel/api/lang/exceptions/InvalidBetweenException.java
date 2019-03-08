package com.admin.panel.api.lang.exceptions;

public class InvalidBetweenException extends RuntimeException {
	private static final long serialVersionUID = -6098917735000137703L;

    public InvalidBetweenException() {
        super();
    }

    public InvalidBetweenException(String message) {
        super(message);
    }

    public InvalidBetweenException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBetweenException(Throwable cause) {
        super(cause);
    }
}
