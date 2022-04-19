package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.model.Book;

@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public void addBook()
	{
		Book book=new Book(9999l, "abcd", 150.25, 100l);
		restTemplate.postForObject("http://localhost:8081/bookstore", book, Book.class);
	}
	
	@PostMapping("/authenticate")
	public void authenticate()
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		String request = "{\"username\":\"user1\",\"password\":\"user123\"}";
		
		HttpEntity<String> entity = new HttpEntity<String>(request,headers);
		
		String token = restTemplate.postForObject("http://localhost:8086/authenticate", entity, String.class);
		System.out.println(token);
		
		headers.add("Authorization", "Bearer "+token);
		
		HttpEntity<String> entity1 = new HttpEntity<String>(headers);
		ResponseEntity<String> responseString = restTemplate.exchange("http://localhost:8086/user/hello", HttpMethod.GET,entity1,String.class);
	 System.out.println(responseString.getBody());
	
	}
}
