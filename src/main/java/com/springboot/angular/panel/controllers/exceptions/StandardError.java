package com.springboot.angular.panel.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	
	private String error;
	
	private String path;
	
	private Long timestamp;
	
	public StandardError() {
		
	}
	
	public StandardError(Integer status, String error, Long timestamp, String path) {
		super();
		this.status = status;
		this.error = error;
		this.timestamp = timestamp;
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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
}
