package com.admin.panel.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.admin.panel.api.interceptors.AuthenticatedInterceptor;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

	@Autowired
	private AuthenticatedInterceptor authenticatedInterceptor;

	private static final String[] PUBLIC_MATCHERS = { 
		"/h2-console/**",
	};

	private static final String[] AUTHENTICATED_MATCHERS = {
		
	};

	private static final String[] NOT_AUTHENTICATED_MATCHERS = {
		"/auth/login", 
		"/auth/forgot-password",
		"/auth/reset-password", 
		"/auth/register",
	};

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if (NOT_AUTHENTICATED_MATCHERS.length > 0) {
			registry.addInterceptor(authenticatedInterceptor)
					.excludePathPatterns(PUBLIC_MATCHERS)
					.excludePathPatterns(NOT_AUTHENTICATED_MATCHERS)
					.addPathPatterns(AUTHENTICATED_MATCHERS);
		} else {
			registry.addInterceptor(authenticatedInterceptor)
					.excludePathPatterns(PUBLIC_MATCHERS)
					.addPathPatterns(AUTHENTICATED_MATCHERS);
		}
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}