package com.training.config;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ExternalConfiguration {
	
	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;
	
	@Value("${myqueue}")
	private String myQueue;
	
	@Bean
	public ActiveMQQueue getActiveMq()
	{
		return new ActiveMQQueue(myQueue);
	}
	
	@Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
       // factory.setTrustedPackages(Arrays.asList("com.training","java.util.ArrayList"));
       factory.setTrustAllPackages(true);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(activeMQConnectionFactory());
    }


}
