package com.training.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class InMemoryConfiguration {
	
	@Value("${myqueue}")
	private String myQueue;
	
	@Bean
	public ActiveMQQueue getActiveMq()
	{
		return new ActiveMQQueue(myQueue);
	}

	
}
