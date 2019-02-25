package com.admin.panel.api.controllers.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.RegisterDTO;
import com.admin.panel.api.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> register(@Valid @RequestBody RegisterDTO registerDTO) {
		return ResponseEntity.ok().body(userService.create(registerDTO));
	}
}
