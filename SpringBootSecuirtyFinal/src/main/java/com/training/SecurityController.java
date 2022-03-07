package com.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	/*
	 * @GetMapping("/") public String home() { return "home.html"; }
	 */
	@GetMapping("/user/hello")
	public String sayHello()
	{
		return "hello user";
	}
	
	@GetMapping("/admin/hello")
	public String sayHello1()
	{
		return "hello admin";
	}
}
