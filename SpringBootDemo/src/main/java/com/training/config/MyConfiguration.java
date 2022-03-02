package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("number")
@Configuration
public class MyConfiguration {
	
	@Value("${message}")
	private String message;

	public String getMessage() {
		return message;
	}
	
	private int maximum;
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	public int getMaximum() {
		return maximum;
	}
	
	private int minimum;
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	
	
	
	

}
