package com.admin.panel.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.admin.panel.api.domain.User;

public class PaginationDTO<T> implements Serializable {
	private static final long serialVersionUID = -5349731876230100681L;

	private List<T> data;
	
	private Long totalElements;
	
	private Integer totalPages;
	
	private Integer itemsPerPage;
	
	private Integer page;
	
	private Integer numberOfElements;

	private Boolean last;
	
	private Boolean first;
	
	private Boolean empty;
	
	public PaginationDTO() {
	}
	
	@SuppressWarnings("unchecked")
	public PaginationDTO(Page<User> pagination) {
		data = (List<T>) pagination.getContent().stream().map(item -> new UserDTO(item)).collect(Collectors.toList());
		totalElements = pagination.getTotalElements();
		totalPages = pagination.getTotalPages();
		itemsPerPage = pagination.getSize();
		page = pagination.getNumber() + 1;
		numberOfElements = pagination.getNumberOfElements();
		last = pagination.isLast();
		first = pagination.isFirst();
		empty = pagination.isEmpty();
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Boolean getLast() {
		return last;
	}

	public void setLast(Boolean last) {
		this.last = last;
	}

	public Boolean getFirst() {
		return first;
	}

	public void setFirst(Boolean first) {
		this.first = first;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
}
