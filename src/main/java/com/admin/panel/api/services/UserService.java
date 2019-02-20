package com.admin.panel.api.services;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.panel.api.domain.Token;
import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.UserCreateDTO;
import com.admin.panel.api.dto.UserUpdateDTO;
import com.admin.panel.api.mails.RegistrationMail;
import com.admin.panel.api.repositories.UserRepository;
import com.admin.panel.api.security.SecurityContext;
import com.admin.panel.api.security.UserSecurity;
import com.admin.panel.api.services.email.EmailService;
import com.admin.panel.api.services.exceptions.DataIntegrityException;
import com.admin.panel.api.services.exceptions.MailException;
import com.admin.panel.api.services.exceptions.ObjectNotFountException;
import com.admin.panel.api.services.util.DateTimeUtil;
import com.admin.panel.api.services.util.PaginationUtil;

@Service
public class UserService {

    @Value("${default.user.passwordExpiresAtDays}")
	private Integer passwordExpiresAtDays;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Autowired
	private EmailService emailService;

	@Autowired
	private TokenService tokenService;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findById(Integer id) {
		return userRepository.findById(id).orElseThrow(() -> 
			new ObjectNotFountException("Objecto com ID ["+ id + "] não encontrado.")
		);
	}

	public Page<User> paginate(Integer page, Integer linesPerPage, String orderBy, String direction) {
		page = PaginationUtil.normalizePage(page);
		linesPerPage = PaginationUtil.normalizeLinesPerPage(linesPerPage);
		Direction directionType = PaginationUtil.normalizeDirection(direction);

		Pageable pageable = PageRequest.of(page, linesPerPage, directionType, orderBy);

		return userRepository.findAll(pageable);
	}

	@Transactional
	public User create(UserCreateDTO userCreateDTO) {
		User user = new User(userCreateDTO);
		
		user.setPassword(bCrypt.encode(userCreateDTO.getPassword()));
		
		if (user.getPasswordExpiresAt() == null) {
			user.setPasswordExpiresAt(DateTimeUtil.getDateWithAddDays(passwordExpiresAtDays));
		}
		
		userRepository.save(user);
		Token token = tokenService.createByRegistration(user);

		try {
			emailService.send(new RegistrationMail(user, token));
		} catch (MessagingException e) {
			throw new MailException(e);
		}
		
		return user;
	}

	public User update(Integer id, UserUpdateDTO userUpdateDTO) {
		User user = findById(id);
		
		user.setName(userUpdateDTO.getName());
		
		return userRepository.save(user);
	}

	public void delete(Integer id) {
		User user = findById(id);
		UserSecurity userSecurity = SecurityContext.getUserSecurity();
		
		if (userSecurity.equals(user)) {
			throw new DataIntegrityException("Não é possível excluir seu próprio usuário.");
		}
		
		userRepository.delete(user);
	}
}