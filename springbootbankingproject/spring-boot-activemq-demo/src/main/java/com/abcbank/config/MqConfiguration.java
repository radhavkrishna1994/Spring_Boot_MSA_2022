package com.abcbank.config;



import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

//with external active mq
//@Configuration
public class MqConfiguration {
	
	@Value("${spring.activemq.broker-url}")
	private String mqUrl;
	
	@Value("${myqueue}")
	private String queue;
	
	@Bean
	public ActiveMQQueue getMQ()
	{
		return new ActiveMQQueue(queue);
	}
	
	@Bean
	public ActiveMQConnectionFactory getMqFactory()
	{
		ActiveMQConnectionFactory myFactory = new ActiveMQConnectionFactory(mqUrl);
		myFactory.setTrustAllPackages(true);
		return myFactory;
	}
	
	@Bean
	public JmsTemplate getTemplate()
	{
		return new JmsTemplate(getMqFactory()); 
	}
	
	
	
	
	 
	 

}
