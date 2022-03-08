package com.training.controllers;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.MessageProducerService;

@RestController
public class JmsController {
	
	@Autowired
	private MessageProducerService messageService;	
		
	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable("message") String message)
	{
		return messageService.postMessage(message);
	}
	@PostMapping("/publish/order")
	public String publishOrder(@RequestBody Order order)
	{
		return messageService.postOrder(order);
	}
	
	@PostMapping("/publish/orders")
	public String postOrder(@RequestBody List<Order> orders)
	{
		return messageService.postOrders(orders);
	}

}

