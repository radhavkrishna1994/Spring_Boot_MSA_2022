package com.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@ComponentScan("com.training.*")
// spring-servlet.xml
public class MyConfiguration extends WebMvcConfigurerAdapter{
	
	
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer
	  configurer) { configurer.enable(); }
	 


	
}
