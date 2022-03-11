package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class MyConfig {
	
	@Value("${message}")
	private String message;
	
	public String getMessage()
	{
		return message;
	}

}
