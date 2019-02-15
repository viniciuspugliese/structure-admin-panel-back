package com.admin.panel.api.config;

import java.text.ParseException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.admin.panel.api.services.email.EmailService;
import com.admin.panel.api.services.email.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
