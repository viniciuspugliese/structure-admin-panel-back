package com.admin.panel.api.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.admin.panel.api.dto.annotations.Exists;

public class ForgotPasswordDTO implements Serializable {
	private static final long serialVersionUID = -7694123104324733090L;

	@NotEmpty(message = "O email é obrigatório.")
	@Email(message = "O email é inválido.")
	@Exists(message = "O email não existe no sistema.", table = "users", collumn = "email", conditions = "deleted_at IS NULL")
	private String email;

	public ForgotPasswordDTO() {
	}

	public ForgotPasswordDTO(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ForgotPasswordDTO other = (ForgotPasswordDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
