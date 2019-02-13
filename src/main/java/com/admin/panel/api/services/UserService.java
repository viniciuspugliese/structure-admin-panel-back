package com.admin.panel.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findById(Integer id) {
		return userRepository.findById(id).orElseGet(() -> null);
	}
	
}
