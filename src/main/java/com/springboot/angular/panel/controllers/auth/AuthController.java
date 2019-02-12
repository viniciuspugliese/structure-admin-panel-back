package com.springboot.angular.panel.controllers.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angular.panel.dto.LoginDTO;
import com.springboot.angular.panel.security.UserSecurity;
import com.springboot.angular.panel.services.auth.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserSecurity> login(@Valid @RequestBody LoginDTO loginDTO) {
		return ResponseEntity.ok().body(authService.login(loginDTO));
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Void> logout() {
		authService.logout();
		return ResponseEntity.noContent().build();
	}
}
