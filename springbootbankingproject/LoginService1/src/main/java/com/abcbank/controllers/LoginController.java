package com.abcbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.bean.Account;
import com.abcbank.services.CustomerService;


@RestController
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello";
	}
	
	@GetMapping("/getaccounts/custid/{custid}")
	public List<Account> getAllAccounts(@PathVariable("custid") long custId)
	{
		return customerService.getAllAccounts(custId);
	}
	@GetMapping("/getaccount1/accountno/{accountno}")
	public Account getAccount(@PathVariable("accountno") long accountNo)
	{
		return customerService.getAccount(accountNo);
	}
}
