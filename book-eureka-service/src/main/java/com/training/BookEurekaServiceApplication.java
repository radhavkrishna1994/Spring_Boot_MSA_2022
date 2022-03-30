package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BookEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookEurekaServiceApplication.class, args);
	}

}
