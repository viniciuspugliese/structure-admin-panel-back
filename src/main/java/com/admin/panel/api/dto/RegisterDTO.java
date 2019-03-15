package com.admin.panel.api.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.admin.panel.api.dto.annotations.EqualFields;
import com.admin.panel.api.dto.annotations.Unique;

@EqualFields(message = "A senha e sua confirmação não coincidem.", baseField = "password", matchField = "passwordConfirmation")
public class RegisterDTO implements Serializable {
	private static final long serialVersionUID = -397299477621685324L;

	@NotEmpty(message = "O nome é obrigatório.")
	private String name;

	@NotEmpty(message = "O email é obrigatório.")
	@Email(message = "O email é inválido.")
	@Unique(message = "O email não existe no sistema.", table = "users", collumn = "email", conditions = "deleted_at IS NULL")
	private String email;

	@NotEmpty(message = "A senha é obrigatória.")
	private String password;

	@NotEmpty(message = "A confirmação da senha é obrigatória.")
	private String passwordConfirmation;

	public RegisterDTO() {
	}

	public RegisterDTO(String name, String email, String password, String passwordConfirmation) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}
