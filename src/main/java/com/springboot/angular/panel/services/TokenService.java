package com.springboot.angular.panel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.panel.domain.Token;
import com.springboot.angular.panel.domain.User;
import com.springboot.angular.panel.domain.enuns.TokenType;
import com.springboot.angular.panel.repositories.TokenRepository;
import com.springboot.angular.panel.security.UserSecurity;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	
	public Token create(UserSecurity userSecurity, User user) {
		Token token = new Token(userSecurity.getToken(), TokenType.AUTHENTICATION, user);
		
		return tokenRepository.save(token);
	}

	public boolean existsAuthorization(String token, Integer user_id) {
		return tokenRepository.countByTokenAndTypeAndUserId(token, TokenType.AUTHENTICATION.value(), user_id) > 0;
	}
}
