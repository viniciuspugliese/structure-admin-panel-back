package com.springboot.angular.panel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "http_logs")
@SQLDelete(sql = "UPDATE logs SET deleted_at = current_timestamp() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class HttpLog implements Serializable {
	private static final long serialVersionUID = 2632888204447997135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ip;

	private String url;

	private Integer httpStatus;
	
	private Integer excepitonLineNumber;
	
	private String excepitonClass;

	private String excepitonMethod;
	
	private String exceptionMessage;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	private Date deletedAt;

	public HttpLog() {
		
	}

	public HttpLog(Integer id, String ip, String url, Integer httpStatus, Integer excepitonLineNumber,
			String excepitonClass, String excepitonMethod, String exceptionMessage, User user, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super();
		this.id = id;
		this.ip = ip;
		this.url = url;
		this.httpStatus = httpStatus;
		this.excepitonLineNumber = excepitonLineNumber;
		this.excepitonClass = excepitonClass;
		this.excepitonMethod = excepitonMethod;
		this.exceptionMessage = exceptionMessage;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Integer getExcepitonLineNumber() {
		return excepitonLineNumber;
	}

	public void setExcepitonLineNumber(Integer excepitonLineNumber) {
		this.excepitonLineNumber = excepitonLineNumber;
	}

	public String getExcepitonClass() {
		return excepitonClass;
	}

	public void setExcepitonClass(String excepitonClass) {
		this.excepitonClass = excepitonClass;
	}

	public String getExcepitonMethod() {
		return excepitonMethod;
	}

	public void setExcepitonMethod(String excepitonMethod) {
		this.excepitonMethod = excepitonMethod;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		HttpLog other = (HttpLog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HttpLog [id=" + id + ", ip=" + ip + ", url=" + url + ", httpStatus=" + httpStatus
				+ ", excepitonLineNumber=" + excepitonLineNumber + ", excepitonClass=" + excepitonClass
				+ ", excepitonMethod=" + excepitonMethod + ", exceptionMessage=" + exceptionMessage + ", user=" + user
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
}
