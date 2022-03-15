package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/helloservice1")
@SpringBootApplication
public class HelloService1Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloService1Application.class, args);
	}

	@GetMapping("/hello1")
	public String sayHello(/* @RequestHeader("my-request-header") String requestHeader */)
	{
		return "hello1 - service: ";//+ requestHeader ;
	}
}
