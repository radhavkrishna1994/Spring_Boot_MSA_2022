package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;
import com.training.bean.OperatorDemo;
import com.training.config.MyConfiguration;

/**
 * Hello world!
 *
 */
public class App3 
{
    public static void main( String[] args )
    {
       //  load the config file
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
    	HelloWorld helloBean = ctx.getBean(HelloWorld.class);
    	helloBean.setMessage("some message");
    	System.out.println(helloBean.sayHello());
    	
    	
    	OperatorDemo demo = ctx.getBean(OperatorDemo.class);
    	demo.printResult(12, 34);
    }
}





