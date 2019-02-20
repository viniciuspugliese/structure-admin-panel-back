package com.admin.panel.api.security;

import java.io.Serializable;
import java.util.Date;

import com.admin.panel.api.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserSecurity implements Serializable {
	private static final long serialVersionUID = 3769952483316175243L;

	private Integer id;
	
	private String name;
	
	private String email;
	
	private Date emailVerifiedAt;

	private Date passwordExpiresAt;
	
	@JsonIgnore
	private String token;

	private Date createdAt;

	private Date updatedAt;

	public UserSecurity() {
		
	}
	
	public UserSecurity(Integer id, String name, String email, Date email_verified_at, Date passwordExpiresAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.emailVerifiedAt = email_verified_at;
		this.passwordExpiresAt = passwordExpiresAt;
	}

	public UserSecurity(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		emailVerifiedAt = user.getEmailVerifiedAt();
		passwordExpiresAt = user.getPasswordExpiresAt();
		createdAt = user.getCreatedAt();
		updatedAt = user.getUpdatedAt();
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserSecurity other = (UserSecurity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean equals(User user) {
		if (user == null)
			return false;

		if (id == null) {
			if (user.getId() != null)
				return false;
		} else if (!id.equals(user.getId()))
			return false;
		
		return true;
	}
}
