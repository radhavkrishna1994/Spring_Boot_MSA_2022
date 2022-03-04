package com.abcbank.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abcbank.bean.Account;
import com.abcbank.interfaces.MyFeignClient;


//@RestController
public class WalletController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//private String url="http://localhost:8083/account";
	private String url = "http://localhost:8081/getaccount1/accountno/{accountno}";

	@GetMapping("/getaccount/accountno/{accountno}")
	public Account getAccount(@PathVariable("accountno") long accountNo)
	{
		// HttpHeaders headers = new HttpHeaders();
         //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		  Map<String,Long> map=new HashMap<>(); 
		  map.put("accountno", accountNo);
		  Account account = restTemplate.getForObject(url, Account.class, map); 
		  
		 
		 
		return account;
	}
	
	@Autowired
	private MyFeignClient myFeignClient;
	
	//http://localhost:8093/customer/api/getpbook/isbn/456/qty/10
	@GetMapping("/getaccountfeign/accountno/{accountno}")
	public Account getAccount1(@PathVariable("accountno") long accountno
			)
	{
		Account account = myFeignClient.getAccount(accountno);
						
		return account;
	}
	


}
