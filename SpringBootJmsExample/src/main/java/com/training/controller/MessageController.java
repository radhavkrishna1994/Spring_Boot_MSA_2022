package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.MessageProducerService;
import com.training.services.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageProducerService messageService;

	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable("message") String message)
	{
		return messageService.postMessage(message);
	}


	@PostMapping("/publish") 
	public String postOrder(@RequestBody Order order) {
		return messageService.postOrder(order); 
		}
	

	@PostMapping("/publish/orders") 
	public String postOrder(@RequestBody List<Order> order) {
		return messageService.postOrders(order); 
		}


}
