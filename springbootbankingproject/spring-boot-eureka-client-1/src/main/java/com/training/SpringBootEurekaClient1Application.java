package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootEurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaClient1Application.class, args);
	}

}
