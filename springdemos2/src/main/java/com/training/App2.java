package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;
import com.training.bean.OperatorDemo;

/**
 * Hello world!
 *
 */
public class App2 
{
    public static void main( String[] args )
    {
       //  load the config file
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	OperatorDemo demo = (OperatorDemo)ctx.getBean("demo");
    	
    	demo.printResult(12, 23);
    }
}


