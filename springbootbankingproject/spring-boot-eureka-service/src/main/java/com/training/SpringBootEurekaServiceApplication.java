package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaServiceApplication.class, args);
	}

}
