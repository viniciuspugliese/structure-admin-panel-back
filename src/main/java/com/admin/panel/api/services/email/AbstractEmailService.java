package com.admin.panel.api.services.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.admin.panel.api.mails.Mail;

public abstract class AbstractEmailService implements EmailService {

	@Value("${mail.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	protected MimeMessage prepareMimeMailMessage(Mail mail) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setTo(mail.getTo());
		mimeMessageHelper.setFrom(sender);
		mimeMessageHelper.setSubject(mail.getSubject());
		mimeMessageHelper.setSentDate(mail.getSentDate());
		mimeMessageHelper.setText(handlerTemplate(mail), true);
		
		return mimeMessage;
	}

	private String handlerTemplate(Mail mail) {
		Context context = new Context();
		
		context.setVariables(mail.getVariables());
		
		return templateEngine.process(mail.getTemplate(), context);
	}
}
