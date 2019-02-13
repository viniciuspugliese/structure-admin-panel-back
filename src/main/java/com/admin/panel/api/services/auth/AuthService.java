package com.admin.panel.api.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.LoginDTO;
import com.admin.panel.api.repositories.UserRepository;
import com.admin.panel.api.security.JWTAuthenticationFilter;
import com.admin.panel.api.security.JWTUtil;
import com.admin.panel.api.security.UserSecurity;
import com.admin.panel.api.security.exception.UnauthorizedException;
import com.admin.panel.api.services.TokenService;

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
