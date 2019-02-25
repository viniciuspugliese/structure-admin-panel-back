package com.admin.panel.api.services.auth;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.Token;
import com.admin.panel.api.domain.User;
import com.admin.panel.api.mails.RegistrationMail;
import com.admin.panel.api.repositories.UserRepository;
import com.admin.panel.api.security.SecurityContext;
import com.admin.panel.api.security.UserSecurity;
import com.admin.panel.api.security.exception.UnauthorizedException;
import com.admin.panel.api.services.TokenService;
import com.admin.panel.api.services.email.EmailService;
import com.admin.panel.api.services.exceptions.MailException;
import com.admin.panel.api.services.util.DateTimeUtil;

@Service
public class VerificationService {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	public void verify(String token) {
		Token userToken = tokenService.existsVerification(token);
		if (userToken == null) {
			throw new UnauthorizedException("O token não existe.");
		}
		
		User user = userToken.getUser();
		user.setEmailVerifiedAt(DateTimeUtil.getDate());
		
		userRepository.save(user);
		tokenService.expires(token);
	}
	
	public void resend() {
		UserSecurity userSecurity = SecurityContext.getUserSecurity();
		User user = userRepository.findByEmail(userSecurity.getEmail());
		Token token = tokenService.createByRegistration(user);

		try {
			emailService.send(new RegistrationMail(user, token));
		} catch (MessagingException e) {
			throw new MailException(e);
		}
	}
}
