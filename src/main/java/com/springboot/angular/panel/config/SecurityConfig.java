package com.springboot.angular.panel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.angular.panel.interceptors.AuthenticatedInterceptor;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

	@Autowired
	private AuthenticatedInterceptor authenticatedInterceptor;

	private static final String[] PUBLIC_MATCHERS = { 
		"/h2-console/**",
		"/auth/login", 
		"/auth/forgot-password",
		"/auth/reset-password", 
		"/auth/register",
	};

	private static final String[] AUTHENTICATED_MATCHERS = {
		
	};

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenticatedInterceptor)
				.excludePathPatterns(PUBLIC_MATCHERS)
				.addPathPatterns(AUTHENTICATED_MATCHERS);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}