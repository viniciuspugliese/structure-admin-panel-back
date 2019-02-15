package com.admin.panel.api.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.admin.panel.api.controllers.exceptions.StandardError;
import com.admin.panel.api.domain.HttpLog;
import com.admin.panel.api.domain.User;
import com.admin.panel.api.repositories.HttpLogRepository;
import com.admin.panel.api.security.SecurityContext;
import com.admin.panel.api.security.UserSecurity;

@Service
public class HttpLogService {

	@Autowired
	private HttpLogRepository logRepository;

	@Autowired
	private UserService userService;

	@Async
	public HttpLog create(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		
		HttpLog httpLog = new HttpLog();
		
		httpLog.setUrl(request.getRequestURL().toString());
		httpLog.setIp(request.getRemoteAddr());
		httpLog.setHttpStatus(response.getStatus());
		
		handlerException(httpLog, exception);
		handlerUser(httpLog);
		
		return logRepository.save(httpLog);
	}

	@Async
	public HttpLog create(HttpServletRequest request, StandardError exception) {

		HttpLog httpLog = new HttpLog();
		
		httpLog.setUrl(request.getRequestURL().toString());
		httpLog.setIp(request.getRemoteAddr());
		httpLog.setHttpStatus(exception.getStatus());
		
		handlerException(httpLog, exception);
		handlerUser(httpLog);
		
		return logRepository.save(httpLog);
		
	}
	
	private void handlerUser(HttpLog httpLog) {
		UserSecurity userSecurity = SecurityContext.getUserSecurity();
		
		if (userSecurity == null) {
			return;
		}

		User user = userService.findById(userSecurity.getId());
		httpLog.setUser(user);
	}

	private void handlerException(HttpLog httpLog, Exception exception) {
		if (exception == null) {
			return;
		}

		httpLog.setExceptionMessage(exception.getMessage());
		httpLog.setExcepitonClass(exception.getClass().getName());
		httpLog.setExcepitonLineNumber(exception.getStackTrace()[0].getLineNumber());
		httpLog.setExcepitonMethod(exception.getStackTrace()[0].getMethodName());
	}

	private void handlerException(HttpLog httpLog, StandardError exception) {
		if (exception == null) {
			return;
		}

		httpLog.setExceptionMessage(exception.getMessage());
		httpLog.setExcepitonClass(exception.getClass().getName());
		httpLog.setExcepitonLineNumber(exception.getCause()[0].getLineNumber());
		httpLog.setExcepitonMethod(exception.getCause()[0].getMethodName());
	}
}
