package com.admin.panel.api.interceptors;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InputReaderInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		ServletInputStream servletInputStream = request.getInputStream();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
//		JsonParser p0 = objectMapper.getFactory().createParser(servletInputStream);
//		JavaType valueType = objectMapper.getTypeFactory().constructType(Object.class);
		
		
		
		
		
		
		
		
		
//		ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
//		Object object = ois.readObject();

//		ResetPasswordDTO resetPasswordDTO = new ObjectMapper().readValue(request.getInputStream(), ResetPasswordDTO.class);
//		InputReaderUtil.setInput(resetPasswordDTO);
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
