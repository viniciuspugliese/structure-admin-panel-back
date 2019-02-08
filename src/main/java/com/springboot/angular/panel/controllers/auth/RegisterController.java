package com.springboot.angular.panel.controllers.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ResponseEntity<String> register() {
		return ResponseEntity.ok().body("Auth register");
	}
}
