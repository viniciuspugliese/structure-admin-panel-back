package com.admin.panel.api.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.services.exceptions.AuthenticationCredentialsNotFoundException;

@Component
public class JWTAuthenticationFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	public JWTAuthenticationFilter() {
		
	}
	
	public UserSecurity attemptAuthentication(User user, String password) {
		if (! bCrypt.matches(password, user.getPassword())) {
			throw new AuthenticationCredentialsNotFoundException("A senha não coincide com o email informado.");
		}
		
		UserSecurity userSecurity = new UserSecurity(user);
		userSecurity.setToken(successfulAuthentication(userSecurity));
		SecurityContext.setUserSecurity(userSecurity);
		
		return userSecurity;
	}
	
	public String successfulAuthentication(UserSecurity userSecurity) {
		String email = userSecurity.getEmail();
		String token = jwtUtil.generateToken(email);
		
		response.addHeader("Authorization", "Bearer " + token);
		
		return token;
	}
}
