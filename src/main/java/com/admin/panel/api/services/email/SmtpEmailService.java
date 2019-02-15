package com.admin.panel.api.services.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

import com.admin.panel.api.mails.Mail;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private JavaMailSender javaMailSender; 

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Async
	public void send(Mail mail) throws MessagingException {
		LOG.info("Enviando email HTML...");
		
		MimeMessage mimeMessage = prepareMimeMailMessage(mail);
		javaMailSender.send(mimeMessage);
		
		LOG.info("Email enviado.");
	}
}
