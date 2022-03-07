package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso
@SpringBootApplication
public class MySpringSecurityAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSecurityAuthApplication.class, args);
	}

}
