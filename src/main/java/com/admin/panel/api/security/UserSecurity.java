package com.admin.panel.api.security;

import java.io.Serializable;
import java.util.Date;

import com.admin.panel.api.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserSecurity implements Serializable {
	private static final long serialVersionUID = 3769952483316175243L;

	private Integer id;
	
	private String nome;
	
	private String email;
	
	private Date email_verified_at;
	
	@JsonIgnore
	private String token;
	
	private Date created_at;
	
	private Date updated_at;
	
	private Date deleted_at;
	
	public UserSecurity() {
		
	}
	
	public UserSecurity(Integer id, String nome, String email, Date email_verified_at, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public UserSecurity(User user) {
		id = user.getId();
		nome = user.getNome();
		email = user.getEmail();
		email_verified_at = user.getEmailVerifiedAt();
		created_at = user.getCreatedAt();
		updated_at = user.getUpdatedAt();
		deleted_at = user.getDeletedAt();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(Date email_verified_at) {
		this.email_verified_at = email_verified_at;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
