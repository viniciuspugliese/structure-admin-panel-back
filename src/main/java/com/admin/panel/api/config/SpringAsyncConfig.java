package com.admin.panel.api.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.admin.panel.api.handler.CustomAsyncUncaughtExceptionHandler;

@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {

    @Value("${async.core-pool-size}")
    private Integer corePoolSize;

    @Value("${async.max-pool-size}")
    private Integer maxPoolSize;

    @Value("${async.queue-capacity}")
    private Integer queueCapacity;

	@Override
    public Executor getAsyncExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        
	    executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        
        return executor;
    }
	
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncUncaughtExceptionHandler();
    }
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
