package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/helloservice1")
//@EnableEurekaClient
public class HelloWorldService1Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldService1Application.class, args);
	}

	@GetMapping("/hello1")
	public String sayHello()
	{
		return "Hello Service 1";
	}
}
