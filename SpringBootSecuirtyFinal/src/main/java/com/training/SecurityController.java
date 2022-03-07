package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.MyUser;
import com.training.services.TestService;

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
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/service1")
	//@PreAuthorize(value="hasRole('USER')")
	public MyUser getService1()
	{
		return testService.getService1();
	}
	
	@GetMapping("/serviceall")
	//@PreAuthorize(value="hasRole('USER')")
	public String getServiceAll()
	{
		return testService.getServiceAll();
	}
}
