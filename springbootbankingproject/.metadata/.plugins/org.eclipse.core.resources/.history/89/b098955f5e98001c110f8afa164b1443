package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.config.MyConfiguration;

@EnableFeignClients
@SpringBootApplication
public class BookOrderServiceApplication {

	public static void main(String[] args) {
SpringApplication.run(BookOrderServiceApplication.class, args);
	}
	
	
	@Autowired
	private MyConfiguration config;
	
	
	
	  @Bean CommandLineRunner getRunner(ApplicationContext ctx) { return args->{
	  
	  System.out.println("Url:"+config.getUrl()); }; }
	 



}
