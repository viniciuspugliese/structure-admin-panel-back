package com.admin.panel.api.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Autowired
	private TokenService tokenService;

	public void instantiateTestDatabase() {
		String password = bCrypt.encode("123");
		Date passwordExpiresAt = Calendar.getInstance().getTime();

		User user = userRepository.save(
			new User("Vinicius Pugliesi", "vinicius_pugliesi@outlook.com", password, passwordExpiresAt)
		);
		
		System.out.println(tokenService.createByRecoverPassword(user).getToken());
		
		userRepository.save(new User("Thales Erick Márcio Figueiredo", "thaleserickmarciofigueiredo@outlook.com",
				password, passwordExpiresAt));

		userRepository.save(
				new User("Gabriel Caio Freitas", "gabrielcaiofreitas-74@outlook.com", password, passwordExpiresAt));

		userRepository.save(new User("Anderson Sebastião Ramos", "andersonsebastiaoramos-72@outlook.com", password,
				passwordExpiresAt));

		userRepository.save(new User("Miguel Fernando Marcos Vinicius Lima",
				"mmiguelfernandomarcosviniciuslima@outlook.com", password, passwordExpiresAt));

		userRepository.save(new User("Gabriel Marcos Vinicius Leandro Lopes",
				"gabrielmarcosviniciusleandrolopes-97@outlook.com", password, passwordExpiresAt));

		userRepository
				.save(new User("Cauê Calebe Duarte", "cauecalebeduarte-81@outlook.com", password, passwordExpiresAt));
		
	}
}
