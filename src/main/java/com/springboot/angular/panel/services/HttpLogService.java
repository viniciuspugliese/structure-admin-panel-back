package com.springboot.angular.panel.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.panel.domain.HttpLog;
import com.springboot.angular.panel.repositories.HttpLogRepository;

@Service
public class HttpLogService {

	@Autowired
	private HttpLogRepository logRepository;

	public HttpLog create(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		
		HttpLog httpLog = new HttpLog();
		
		httpLog.setUrl(request.getRequestURL().toString());
		httpLog.setIp(request.getRemoteAddr());
		httpLog.setHttpStatus(response.getStatus());
		
		if (exception != null) {
			httpLog.setExceptionMessage(exception.getMessage());
			httpLog.setExcepitonClass(exception.getClass().getName());
			httpLog.setExcepitonLineNumber(exception.getStackTrace()[0].getLineNumber());
			httpLog.setExcepitonMethod(exception.getStackTrace()[0].getMethodName());
		}
		
		return logRepository.save(httpLog);
	}
}
