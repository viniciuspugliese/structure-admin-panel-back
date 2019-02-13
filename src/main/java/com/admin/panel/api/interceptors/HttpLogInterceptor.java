package com.admin.panel.api.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.admin.panel.api.controllers.exceptions.StandardError;
import com.admin.panel.api.services.HttpLogService;

@Component
public class HttpLogInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpLogService httpLogService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		httpLogService.create(request, response, handler, exception);
	}

	public void afterCompletion(StandardError exception, HttpServletRequest request) {
		httpLogService.create(request, exception);
	}
}