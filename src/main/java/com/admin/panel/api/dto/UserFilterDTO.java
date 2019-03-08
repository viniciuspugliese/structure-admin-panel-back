package com.admin.panel.api.dto;

import java.io.Serializable;

import javax.validation.Valid;

import com.admin.panel.api.dto.annotations.BetweenCompare;
import com.admin.panel.api.lang.Between;

public class UserFilterDTO implements Serializable {
	private static final long serialVersionUID = 136164056467398159L;

	private String name;
	
	private String email;

	@Valid
	@BetweenCompare(message = "O range de datas de criação é inválido.", dateFormat = "dd/MM/yyyy HH:mm:ss")
	private Between<String> createdBetween;
	
	public UserFilterDTO() {
	}

	public UserFilterDTO(String name, String email, Between<String> createdBetween) {
		super();
		this.name = name;
		this.email = email;
		this.createdBetween = createdBetween;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Between<String> getCreatedBetween() {
		return createdBetween;
	}

	public void setCreatedBetween(Between<String> createdBetween) {
		this.createdBetween = createdBetween;
	}
}
