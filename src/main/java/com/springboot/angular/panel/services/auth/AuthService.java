package com.springboot.angular.panel.services.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.angular.panel.domain.User;
import com.springboot.angular.panel.dto.LoginDTO;
import com.springboot.angular.panel.repositories.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	public User login(LoginDTO loginDTO) {
		User user = userRepository.findByEmail(loginDTO.getEmail());
		
		if (user == null) {
//			throw new Auth
		}
		
		
		
		return user;
	}
	
	public List<User> logout() {
		User entity = new User();
		entity.setEmail("vinicius_pugliesi@outlook.com");
		entity.setPassword("123");
		entity.setNome("Vinicius");
		
		userRepository.save(entity);
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		entity.setPassword("1234");
//		userRepository.save(entity);
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		Pageable firstPageWithTwoElements = PageRequest.of(0, 3);
//		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		
//		userRepository.delete(entity);
		
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(2);
		ids.add(3);
		
//		return userRepository.findAll(firstPageWithTwoElements);
//		return userRepository.findAll(sort);
		return userRepository.findAllById(ids);
	}
}
