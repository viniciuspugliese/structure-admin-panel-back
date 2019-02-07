package com.springboot.angular.panel.resources.auth;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angular.panel.domain.User;
import com.springboot.angular.panel.dto.LoginDTO;
import com.springboot.angular.panel.services.auth.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {
		authService.login(loginDTO);
		return ResponseEntity.ok().body("Auth login");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<List<User>> logout() {
		return ResponseEntity.ok().body(authService.logout());
	}
}
