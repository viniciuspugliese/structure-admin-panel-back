package com.springboot.angular.panel.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.angular.panel.domain.User;
import com.springboot.angular.panel.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	public void instantiateTestDatabase() {
		User user = new User("Vinicius", "vinicius_pugliesi@outlook.com", bCrypt.encode("123"), new Date(System.currentTimeMillis()));
		
		userRepository.save(user);
	}
}
