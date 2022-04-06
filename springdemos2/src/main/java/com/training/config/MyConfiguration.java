package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.bean.AddOperator;
import com.training.bean.HelloWorld;
import com.training.bean.MultiplyOperator;
import com.training.bean.OperatorDemo;
import com.training.interfaces.Operator;

@Configuration
public class MyConfiguration {
	
	
	@Bean(initMethod = "init")
	public HelloWorld getHelloWorld()
	{
		return new HelloWorld();
	}
	
	@Bean(name="op")
	public Operator getOperator()
	{
		return new AddOperator();
	}
	
	@Bean(name="op1")
	public Operator getOperator1()
	{
		return new MultiplyOperator();
	}
	
	@Bean
	public OperatorDemo getOperatorDemo()
	{
		OperatorDemo demo = new OperatorDemo();
	//	demo.setOperator(getOperator());
		return demo;
	}

}




