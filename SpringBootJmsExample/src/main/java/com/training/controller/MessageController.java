package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable("message") String message)
	{
		return messageService.publishMessage(message);
	}
	
	@PostMapping("/publish")
	public String postOrder(@RequestBody Order order)
	{
		return messageService.publishOrder(order);
	}
	
	
}
