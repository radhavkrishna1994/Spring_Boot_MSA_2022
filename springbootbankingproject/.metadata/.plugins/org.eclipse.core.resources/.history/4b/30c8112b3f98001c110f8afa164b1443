package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {
	
	@Value("${serviceurl}")  // git repo
	private String serviceurl;
	
	
	public String getUrl()
	{
		return serviceurl;
	}
	
	
	  @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
	 

	
}
