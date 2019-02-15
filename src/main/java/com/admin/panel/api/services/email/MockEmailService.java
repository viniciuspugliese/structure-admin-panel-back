package com.admin.panel.api.services.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.admin.panel.api.mails.Mail;

public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Async
	@Override
	public void send(Mail mail) throws MessagingException {
		LOG.info("Simulando envio de email...");

		MimeMessage mimeMessage = prepareMimeMailMessage(mail);
		LOG.info(mimeMessage.toString());
		
		LOG.info("Email enviado.");
	}
}
