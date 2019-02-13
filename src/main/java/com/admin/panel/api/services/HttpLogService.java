package com.admin.panel.api.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.panel.api.domain.HttpLog;
import com.admin.panel.api.repositories.HttpLogRepository;

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
