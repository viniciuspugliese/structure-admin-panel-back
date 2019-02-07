package com.springboot.angular.panel.resources.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class RegisterResource {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ResponseEntity<String> register() {
		return ResponseEntity.ok().body("Auth register");
	}
}
