package com.admin.panel.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.admin.panel.api.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 2359036157897492616L;

	private Integer id;
	
	private String name;
	
	private String email;
	
	private Date emailVerifiedAt;

	private Date passwordExpiresAt;

	private Date createdAt;

	private Date updatedAt;

	public UserDTO() {
	}

	public UserDTO(Integer id, String name, String email, Date emailVerifiedAt, Date passwordExpiresAt, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.emailVerifiedAt = emailVerifiedAt;
		this.passwordExpiresAt = passwordExpiresAt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.emailVerifiedAt = user.getEmailVerifiedAt();
		this.passwordExpiresAt = user.getPasswordExpiresAt();
		this.createdAt = user.getCreatedAt();
		this.updatedAt = user.getUpdatedAt();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getEmailVerifiedAt() {
		return emailVerifiedAt;
	}

	public void setEmailVerifiedAt(Date emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Date getPasswordExpiresAt() {
		return passwordExpiresAt;
	}

	public void setPasswordExpiresAt(Date passwordExpiresAt) {
		this.passwordExpiresAt = passwordExpiresAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
