package com.admin.panel.api.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.panel.api.services.auth.VerificationService;

@RestController
@RequestMapping(value = "/auth")
public class VerificationController {

	@Autowired
	private VerificationService verificationService;
	
	@RequestMapping(value = "/email-verification", method = RequestMethod.GET)
	public ResponseEntity<Void> verify(@RequestParam("token") String token) {
		verificationService.verify(token);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/resend-verification", method = RequestMethod.GET)
	public ResponseEntity<Void> resend() {
		verificationService.resend();
		return ResponseEntity.noContent().build();
	}
}
