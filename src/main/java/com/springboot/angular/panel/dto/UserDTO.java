package com.springboot.angular.panel.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = -4573685214256024821L;

	private Integer id;
	
	private String nome;
	
	private String email;
	
	private Date email_verified_at;
	
	private Date created_at;
	
	private Date updated_at;
	
	private Date deleted_at;
	
	public UserDTO() {
		
	}

	public UserDTO(Integer id, String nome, String email, Date email_verified_at, Date created_at,Date updated_at, 
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((deleted_at == null) ? 0 : deleted_at.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email_verified_at == null) ? 0 : email_verified_at.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (deleted_at == null) {
			if (other.deleted_at != null)
				return false;
		} else if (!deleted_at.equals(other.deleted_at))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email_verified_at == null) {
			if (other.email_verified_at != null)
				return false;
		} else if (!email_verified_at.equals(other.email_verified_at))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", email_verified_at=" + email_verified_at
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}

	
}
