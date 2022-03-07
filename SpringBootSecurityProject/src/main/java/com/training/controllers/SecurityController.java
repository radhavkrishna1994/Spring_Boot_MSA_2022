package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/")
	public String sayHello()
	{
		return "Hello! This is a Security App";
	}
	
	@GetMapping("/user/hello")
	public String sayHelloUser()
	{
		return "Hello! This is a Security App For User";
	}
	
	@GetMapping("/admin/hello")
	public String sayHelloAdmin()
	{
		return "Hello! This is a Security App for Admin";
	}
	
}
