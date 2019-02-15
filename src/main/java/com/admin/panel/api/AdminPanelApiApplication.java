package com.admin.panel.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AdminPanelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminPanelApiApplication.class, args);
	}
}
