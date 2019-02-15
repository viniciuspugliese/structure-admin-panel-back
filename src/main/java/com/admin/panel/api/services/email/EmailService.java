package com.admin.panel.api.services.email;

import javax.mail.MessagingException;

import com.admin.panel.api.mails.Mail;

public interface EmailService {

	public void send(Mail mail) throws MessagingException;
}
