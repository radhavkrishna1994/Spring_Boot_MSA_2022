package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.OrderedBook;
import com.training.services.OrderService;

@RequestMapping("/orders")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/order/isbn/{isbn}/qty/{quantity}")
	public OrderedBook orderBook(@PathVariable("isbn") Long isbn,@PathVariable("quantity") int quantity)
	{
		return orderService.createOrderBook(isbn, quantity);
			
	}
	
	@GetMapping("/orderfeign/isbn/{isbn}/qty/{quantity}")
	public OrderedBook orderBookFeign(@PathVariable("isbn") Long isbn,@PathVariable("quantity") int quantity)
	{
		return orderService.createOrderBookFeign(isbn, quantity);
			
	}
	
}
