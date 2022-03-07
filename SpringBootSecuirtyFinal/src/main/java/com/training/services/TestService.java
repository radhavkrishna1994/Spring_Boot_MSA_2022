package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.training.bean.MyUser;


//https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html

@Service
public class TestService {
	
	@Autowired
	private MyUserDetailsService userService;
	
	@PreAuthorize(value = "hasRole('USER')")
	@PostAuthorize("returnObject.username == principal.username")
	public MyUser getService1()
	{
		System.out.println("Method Executing......");
		return new MyUser("user12", "user1", true,null);
	}
	
	@PreAuthorize(value = "permitAll()")
	public String getServiceAll()
	{
		return "hello service all";
	}

}
