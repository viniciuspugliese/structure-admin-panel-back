package com.admin.panel.api.controllers.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	
	private String message;
	
	private String path;
	
	private Long timestamp;
	
	@JsonIgnore
	private StackTraceElement[] cause; 
	
	public StandardError() {
		
	}
	
	public StandardError(Integer status, String message, Long timestamp, String path) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.path = path;
	}

	public StandardError(Integer status, String message, Long timestamp, String path, StackTraceElement[] cause) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.path = path;
		this.cause = cause;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public StackTraceElement[] getCause() {
		return cause;
	}

	public void setCause(StackTraceElement[] cause) {
		this.cause = cause;
	}
}
