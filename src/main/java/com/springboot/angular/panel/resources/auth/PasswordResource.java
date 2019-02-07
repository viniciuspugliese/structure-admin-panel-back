package com.springboot.angular.panel.resources.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class PasswordResource {

	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public ResponseEntity<String> forgotPassword() {
		return ResponseEntity.ok().body("Forgot password");
	}

	@RequestMapping(value = "/reset-password", method = RequestMethod.GET)
	public ResponseEntity<String> resetPassword() {
		return ResponseEntity.ok().body("Reset password");
	}
}
