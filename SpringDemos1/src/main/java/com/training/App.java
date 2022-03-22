package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;
import com.training.bean.OperatorDemo;

public class App 
{
    public static void main( String[] args )
    {
     //   HelloWorld helloBean = new HelloWorld();
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	HelloWorld helloBean = (HelloWorld)ctx.getBean("hello1");
    	
        System.out.println(helloBean.sayHello());
        
        OperatorDemo opDemo = (OperatorDemo) ctx.getBean("opdemo");
        
        System.out.println("Result:"+opDemo.getResult(12, 10));
    }
}
