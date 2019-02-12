package com.springboot.angular.panel.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.panel.domain.User;
import com.springboot.angular.panel.dto.LoginDTO;
import com.springboot.angular.panel.repositories.UserRepository;
import com.springboot.angular.panel.security.JWTAuthenticationFilter;
import com.springboot.angular.panel.security.JWTUtil;
import com.springboot.angular.panel.security.UserSecurity;
import com.springboot.angular.panel.security.exception.UnauthorizedException;
import com.springboot.angular.panel.services.TokenService;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private TokenService tokenService;
	
	public UserSecurity login(LoginDTO loginDTO) {
		User user = userRepository.findByEmail(loginDTO.getEmail());
		
		UserSecurity userSecurity = jwtAuthenticationFilter.attemptAuthentication(user, loginDTO.getPassword());
		tokenService.create(userSecurity, user);
		
		return userSecurity;
	}
	
	public void logout() {
	}
	
	public UserSecurity loadUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UnauthorizedException("O usuário não existe no sistema.");
		}
		
		return new UserSecurity(user);
	}
}
