package com.training.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.training.classes.AddOperator;
import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;
import com.training.interfaces.Operator;

@Configuration
public class MyConfiguration {

	@Bean
	public HelloWorld getHelloWorldBean()
	{
		return new HelloWorld();
	}
	
	@Bean
	public Operator getOperator()
	{
		return new AddOperator();
	}
	
	@Bean
	//@Scope(scopeName = "prototype")
	public OperatorDemo getOperatorDemo()
	{
		return new OperatorDemo();
	}
	
	
}
