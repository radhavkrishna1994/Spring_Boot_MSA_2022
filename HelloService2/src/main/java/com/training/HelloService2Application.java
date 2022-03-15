package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/helloservice2")
@SpringBootApplication
public class HelloService2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloService2Application.class, args);
	}

	@GetMapping("/hello2")
	public String sayHello()
	{
		return "hello2 - service";
	}
}
