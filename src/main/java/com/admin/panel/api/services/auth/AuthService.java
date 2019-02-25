package com.admin.panel.api.services.auth;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.LoginDTO;
import com.admin.panel.api.mails.DeleteAccountMail;
import com.admin.panel.api.repositories.UserRepository;
import com.admin.panel.api.security.JWTAuthenticationFilter;
import com.admin.panel.api.security.JWTUtil;
import com.admin.panel.api.security.SecurityContext;
import com.admin.panel.api.security.UserSecurity;
import com.admin.panel.api.security.exception.UnauthorizedException;
import com.admin.panel.api.services.TokenService;
import com.admin.panel.api.services.email.EmailService;
import com.admin.panel.api.services.exceptions.MailException;

@Service
public class AuthService {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private JWTUtil jwtUtil;
	
	public UserSecurity login(LoginDTO loginDTO) {
		User user = userRepository.findByEmail(loginDTO.getEmail());
		
		UserSecurity userSecurity = jwtAuthenticationFilter.attemptAuthentication(user, loginDTO.getPassword());
		tokenService.createByAuthentication(userSecurity, user);
		
		return userSecurity;
	}

	public String refreshToken() {
		UserSecurity userSecurity = SecurityContext.getUserSecurity();
		User user = userRepository.findByEmail(userSecurity.getEmail());
		
		logout();
		
		String token = jwtUtil.generateToken(userSecurity.getEmail());
		userSecurity.setToken(token);
		tokenService.createByAuthentication(userSecurity, user);
		
		return token;
	}
	
	public void logout() {
		UserSecurity userSecurity = SecurityContext.getUserSecurity();
		tokenService.expiresAuthentication(userSecurity);
	}
	
	public UserSecurity loadUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UnauthorizedException("O usuário não existe no sistema.");
		}
		
		return new UserSecurity(user);
	}

	public void deleteAccount() {
		UserSecurity userSecurity = SecurityContext.getUserSecurity();
		User user = userRepository.findByEmail(userSecurity.getEmail());

		try {
			emailService.send(new DeleteAccountMail(user));
		} catch (MessagingException e) {
			throw new MailException(e);
		} finally {
			userRepository.delete(user);
		}
	}
}
