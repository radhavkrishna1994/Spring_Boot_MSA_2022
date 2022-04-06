package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       //  load the config file
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	HelloWorld helloBean  = (HelloWorld) ctx.getBean("hello");  // one instance only Singleton
    	
    	System.out.println(helloBean.sayHello());
    	
    	helloBean.setMessage("This is an updated message");
    	
    	HelloWorld helloBean1  = (HelloWorld) ctx.getBean("hello");
    	System.out.println(helloBean1.sayHello()); // 
    }
}


