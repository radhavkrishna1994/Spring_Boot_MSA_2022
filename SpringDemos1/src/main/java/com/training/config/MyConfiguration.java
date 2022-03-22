package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.bean.HelloWorld;
import com.training.bean.MultiplyOperator;
import com.training.bean.OperatorDemo;
import com.training.interaces.Operator;


@Configuration
public class MyConfiguration {

	// HelloBean
	
	@Bean
	public HelloWorld getHelloBean()
	{
		return new HelloWorld("Hello Message from Java class", 20);
	}
	
	
	  @Bean public Operator getOperator() { return new MultiplyOperator(); }
	 
	
	
	@Bean
	public OperatorDemo getOperatorDemo()
	{
		OperatorDemo opDemo= new OperatorDemo(getOperator());
	//	opDemo.setOperator(getOperator());
		return opDemo;
	}
	
}
