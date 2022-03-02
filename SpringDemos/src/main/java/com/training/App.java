package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;

public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		/*
		 * HelloWorld helloBean = (HelloWorld) ctx.getBean("hello"); // default
		 * constructor , setter
		 * 
		 * System.out.println(helloBean.sayHello());
		 * helloBean.setMessage("This is a new message");
		 * System.out.println(helloBean.hashCode());
		 * 
		 * HelloWorld helloBean1 = (HelloWorld) ctx.getBean("hello"); // singleton
		 * System.out.println(helloBean1.hashCode());
		 * 
		 * System.out.println(helloBean1.sayHello());
		 */
    	
    	OperatorDemo operatorDemo = (OperatorDemo) ctx.getBean("opDemo");
    	System.out.println(operatorDemo.getResult(12, 10));
    	
    	
    	
    }
}
