package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.model.OrderedBook;
import com.training.services.OrderService;

@RequestMapping("/orders")
@RestController
public class OrderController {
	
		
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/book/isbn/{isbn}/qty/{qty}")
	public OrderedBook createOrder(@PathVariable("isbn") long isbn,@PathVariable("qty") int qty)
	{
		return orderService.createOrderBook(isbn, qty);
	}
	

}
