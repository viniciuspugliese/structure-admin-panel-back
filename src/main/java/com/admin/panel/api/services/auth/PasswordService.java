package com.admin.panel.api.services.auth;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.Token;
import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.ForgotPasswordDTO;
import com.admin.panel.api.dto.ResetPasswordDTO;
import com.admin.panel.api.mails.ForgotPasswordMail;
import com.admin.panel.api.mails.ResetPasswordMail;
import com.admin.panel.api.repositories.UserRepository;
import com.admin.panel.api.services.TokenService;
import com.admin.panel.api.services.email.EmailService;
import com.admin.panel.api.services.exceptions.MailException;
import com.admin.panel.api.services.util.DateTimeUtil;

@Service
public class PasswordService {

    @Value("${default.user.passwordExpiresAtDays}")
	private Integer passwordExpiresAtDays;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Async
	public void forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		User user = userRepository.findByEmail(forgotPasswordDTO.getEmail());
		Token token = tokenService.createByRecoverPassword(user);

		try {
			emailService.send(new ForgotPasswordMail(user, token));
		} catch (MessagingException e) {
			throw new MailException(e);
		}
	}

	public void resetPassword(ResetPasswordDTO resetPasswordDTO) {
		User user = userRepository.findByEmail(resetPasswordDTO.getEmail());

		user.setPassword(bCrypt.encode(resetPasswordDTO.getPassword()));
		user.setPasswordExpiresAt(DateTimeUtil.getDateWithAddDays(passwordExpiresAtDays));
		userRepository.save(user);
		
		try {
			emailService.send(new ResetPasswordMail(user));
			tokenService.expires(resetPasswordDTO.getToken());
		} catch (MessagingException e) {
			throw new MailException(e);
		}
	}
}
