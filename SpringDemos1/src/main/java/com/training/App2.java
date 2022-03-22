package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;
import com.training.bean.OperatorDemo;
import com.training.config.MyConfiguration;
import com.training.interaces.Operator;

@ComponentScan("com.training.config.*")
public class App2 
{
    public static void main( String[] args )
    {
        	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
		/*
		 * HelloWorld helloBean = ctx.getBean(HelloWorld.class);
		 * 
		 * System.out.println(helloBean.sayHello());
		 */
    	
    	OperatorDemo operatorDemo = ctx.getBean(OperatorDemo.class);
    	
    	System.out.println(operatorDemo.getResult(12, 15));
    	
    }
}
