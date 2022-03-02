package com.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;
import com.training.config.MyConfiguration;

public class App1 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(MyConfiguration.class);
		/*
		 * HelloWorld helloBean = ctx.getBean(HelloWorld.class);
		 * helloBean.setMessage("this is a message");
		 * System.out.println(helloBean.sayHello());
		 */

		
		OperatorDemo operatorDemo = ctx.getBean(OperatorDemo.class);
		System.out.println(operatorDemo.getResult(12, 10));
	}

}
