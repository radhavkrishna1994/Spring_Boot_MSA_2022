package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.config.MyConfig;

@RestController
public class ClientController {
	
	@Autowired
	private MyConfig config;
	
	@GetMapping("/sayhello")
	public String sayHelloClient()
	{
		return config.getMessage();
	}

}
