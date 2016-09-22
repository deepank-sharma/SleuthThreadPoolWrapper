package com.abc.xyz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class SampleConfig {
	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new LogThreadWrapper();
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(50);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		taskExecutor.afterPropertiesSet();
		return taskExecutor;
	}
}
