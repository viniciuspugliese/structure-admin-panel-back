package com.admin.panel.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.admin.panel.api.dto.annotations.Confirmed;
import com.admin.panel.api.dto.annotations.Unique;

public class UserUpdateDTO implements Serializable {
	private static final long serialVersionUID = -397299477621685324L;

	@NotEmpty(message = "O nome é obrigatório.")
	private String name;

	public UserUpdateDTO() {
	}

	public UserUpdateDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
