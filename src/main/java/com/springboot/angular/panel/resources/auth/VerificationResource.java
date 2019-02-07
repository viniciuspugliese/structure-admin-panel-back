package com.springboot.angular.panel.resources.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class VerificationResource {

	@RequestMapping(value = "/email-verification", method = RequestMethod.GET)
	public ResponseEntity<String> verify() {
		return ResponseEntity.ok().body("Auth verify");
	}

	@RequestMapping(value = "/resend-verification", method = RequestMethod.GET)
	public ResponseEntity<String> resend() {
		return ResponseEntity.ok().body("Auth resend");
	}
}
