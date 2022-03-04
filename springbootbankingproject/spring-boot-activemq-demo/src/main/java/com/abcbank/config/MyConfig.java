package com.abcbank.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//with in memory active mq
@Configuration
public class MyConfig {

	@Bean
	public ActiveMQQueue getQueue()
	{
		return new ActiveMQQueue("test-queue");
	}
}
