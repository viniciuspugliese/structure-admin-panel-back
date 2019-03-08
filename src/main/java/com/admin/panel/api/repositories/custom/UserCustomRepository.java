package com.admin.panel.api.repositories.custom;

import java.text.ParseException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.UserFilterDTO;

public interface UserCustomRepository {

	public Page<User> search(Pageable pageable, UserFilterDTO filters, Direction direction, String orderBy) throws ParseException;
}
