package com.admin.panel.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.admin.panel.api.interceptors.HttpLogInterceptor;
import com.admin.panel.api.interceptors.InputReaderInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private HttpLogInterceptor httpLogInterceptor;

	@Autowired
	private InputReaderInterceptor inputReaderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpLogInterceptor).addPathPatterns("/**");
        registry.addInterceptor(inputReaderInterceptor).addPathPatterns("/**");
    }
}