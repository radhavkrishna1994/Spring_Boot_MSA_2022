package com.training.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.WebClientService;
import com.training.model.PurchasedBook;
import com.training.model.PurchasedBookListClass;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@RestController
public class ConsumerController {

	@Autowired
	private WebClientService service;
	
	
	
	
	 /* @GetMapping("/getbooks") public List<PurchasedBook> getAllBooks() {
	  PurchasedBook[] books = service.crawl();
	  
	  return Arrays.stream(books).collect(Collectors.toList());
	  
	  
	  }*/
	 
	 
	 
	
}