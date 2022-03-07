package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.AuthRequest;
import com.training.util.JwtUtil;

@RestController
@RequestMapping("/")
public class BookController {
	
	@GetMapping("/")
	public String sayHello()
	{
		return "hello";
	}
	
	@GetMapping("/user/hello")
	public String sayHelloUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/admin/hello")
	public String sayHelloAdmin()
	{
		return "Hello Admin";
	}
	
	@GetMapping("/admin/hello1")
	public String sayHelloAdmin1()
	{
		return "Hello Admin Again";
	}
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception { //from json input
		System.out.println("input :"+authRequest);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
        	System.out.println("Exception:"+ex);
            throw new Exception("invalid username/password");
        }
       
		return jwtUtil.generateToken(authRequest.getUsername());
    }

}
