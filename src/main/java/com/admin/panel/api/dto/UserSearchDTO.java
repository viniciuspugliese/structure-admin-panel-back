package com.admin.panel.api.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class UserSearchDTO implements Serializable {
	private static final long serialVersionUID = 8060446824258136469L;

	@Min(value = 0, message = "A página deve ser maior ou igual a 0 (zero).")
	private Integer page = 0;

	@Min(value = 0, message = "A quantidade de registros por página deve ser maior ou igual a 1 (um).")
	private Integer itemsPerPage = 10;
	
	private String orderBy = "createdAt";
	
	@Pattern(regexp = "ASC|DESC", message = "O valor é inválido para ordenação. Aceitos: ASC, DESC.")
	private String direction = "DESC";
	
	private UserFilterDTO filters;
	
	public UserSearchDTO() {
	}
	
	public UserSearchDTO(Integer page, Integer itemsPerPage, String orderBy, String direction, UserFilterDTO filters) {
		super();
		this.page = page;
		this.itemsPerPage = itemsPerPage;
		this.orderBy = orderBy;
		this.direction = direction;
		this.filters = filters;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public UserFilterDTO getFilters() {
		return filters;
	}

	public void setFilters(UserFilterDTO filters) {
		this.filters = filters;
	}
}
