package com.admin.panel.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.admin.panel.api.dto.UserCreateDTO;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = current_timestamp() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class User implements Serializable {
	private static final long serialVersionUID = 2632888204447997135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = true)
	private Date emailVerifiedAt;

	@Column(nullable = true)
	private Date passwordExpiresAt;

	@CreationTimestamp
	@Column(nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(nullable = false)
	private Date updatedAt;

	@Column(nullable = true)
	private Date deletedAt;

	public User() {

	}

	public User(Integer id, String name, String email, String password, Date emailVerifiedAt, Date passwordExpiresAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.emailVerifiedAt = emailVerifiedAt;
		this.passwordExpiresAt = passwordExpiresAt;
	}

	public User(String name, String email, String password, Date passwordExpiresAt) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordExpiresAt = passwordExpiresAt;
	}

	public User(UserCreateDTO userDTO) {
		super();
		this.name = userDTO.getName();
		this.email = userDTO.getEmail();
		this.password = userDTO.getPassword();
		this.passwordExpiresAt = userDTO.getPasswordExpiresAt();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
