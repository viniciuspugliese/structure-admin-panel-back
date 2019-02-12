package com.springboot.angular.panel.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.angular.panel.security.exception.UnauthorizedException;
import com.springboot.angular.panel.services.exceptions.AuthenticationCredentialsNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

//	@ExceptionHandler(ObjectNotFountException.class)
//	public ResponseEntity<StandardError> objectNotFound(ObjectNotFountException e, HttpServletRequest request) {
//		
//		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//	}

//	@ExceptionHandler(DataIntegrityException.class)
//	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
//		
//		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request) {

		Integer status = HttpStatus.UNPROCESSABLE_ENTITY.value();
		String message = "Erro de validação.";
		Long timestamp = System.currentTimeMillis();
		String path = request.getRequestURI().toString();

		ValidationError validationError = new ValidationError(status, message, timestamp, path);

		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return ResponseEntity.status(status).body(validationError);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	public ResponseEntity<StandardError> authorization(AuthenticationCredentialsNotFoundException e,
			HttpServletRequest request) {

		Integer status = HttpStatus.UNPROCESSABLE_ENTITY.value();
		String message = e.getMessage();
		Long timestamp = System.currentTimeMillis();
		String path = request.getRequestURI().toString();

		ValidationError validationError = new ValidationError(status, message, timestamp, path);
		validationError.addError("password", e.getMessage());
		
		return ResponseEntity.status(status).body(validationError);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<StandardError> authorization(UnauthorizedException e, HttpServletRequest request) {

		Integer status = HttpStatus.UNAUTHORIZED.value();
		String message = e.getMessage();
		Long timestamp = System.currentTimeMillis();
		String path = request.getRequestURI().toString();

		StandardError err = new StandardError(status, message, timestamp, path);
		return ResponseEntity.status(status).body(err);
	}
	
//	@ExceptionHandler(AuthorizationException.class)
//	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
//		
//		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
//		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
//	}

}
