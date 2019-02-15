package com.admin.panel.api.services.exceptions;

import java.io.Serializable;

public class MailException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 8252854498734086670L;

	public MailException() {
        super();
    }

    public MailException(String message) {
        super(message);
    }

    public MailException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailException(Throwable cause) {
        super(cause);
    }
}
