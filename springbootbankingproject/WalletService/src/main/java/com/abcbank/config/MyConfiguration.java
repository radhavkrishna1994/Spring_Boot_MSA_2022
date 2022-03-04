package com.abcbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter{


	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
		.csrf()
		.disable()
		.authorizeRequests()
	//	.antMatchers("/bank/login")
		.antMatchers("/getaccount/accountno/**")
		.permitAll();
		
		
	

	}
}
