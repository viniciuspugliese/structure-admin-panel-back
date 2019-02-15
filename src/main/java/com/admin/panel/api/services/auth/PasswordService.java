package com.admin.panel.api.services.auth;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.Token;
import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.ForgotPasswordDTO;
import com.admin.panel.api.mails.ForgotPasswordMail;
import com.admin.panel.api.repositories.UserRepository;
import com.admin.panel.api.services.TokenService;
import com.admin.panel.api.services.email.EmailService;
import com.admin.panel.api.services.exceptions.MailException;

@Service
public class PasswordService {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	@Async
	public void forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		User user = userRepository.findByEmail(forgotPasswordDTO.getEmail());
		Token token = tokenService.createByMail(user);
		
		try {
			emailService.send(new ForgotPasswordMail(user, token));
		} catch (MessagingException e) {
			throw new MailException(e);
		}
	}
	
	public void resetPassword() {
		
	}
}
