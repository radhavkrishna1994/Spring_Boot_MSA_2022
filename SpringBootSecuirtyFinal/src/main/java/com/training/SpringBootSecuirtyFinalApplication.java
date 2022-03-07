package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.services.TestService;

@SpringBootApplication
public class SpringBootSecuirtyFinalApplication{// implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecuirtyFinalApplication.class, args);
	}

	/*
	 * @Autowired private TestService testService;
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * System.out.println(testService.getService1());
	 * 
	 * }
	 */
	
	
}
