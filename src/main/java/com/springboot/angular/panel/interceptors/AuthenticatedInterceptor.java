package com.springboot.angular.panel.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.springboot.angular.panel.security.JWTAuthorizationFilter;

@Component
public class AuthenticatedInterceptor implements HandlerInterceptor {

	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		jwtAuthorizationFilter.doFilter(request, response, handler);
		
		return true;
	}
}