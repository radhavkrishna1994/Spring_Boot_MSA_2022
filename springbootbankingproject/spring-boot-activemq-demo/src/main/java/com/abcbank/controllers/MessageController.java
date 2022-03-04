package com.abcbank.controllers;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.bean.Order;


@RestController
public class MessageController {
	@Autowired
	private Queue queue;
	@Autowired
	private JmsTemplate jmsTemplate;
	
		
	@GetMapping("/publish/{message}")
	public String publishAndSend(@PathVariable("message") String message)
	{
			jmsTemplate.convertAndSend(queue, message);
			return message + " published";
	}
	
	@PostMapping("/sendorder")
	public String publishAndSendOrder(@RequestBody Order order)
	{
		System.out.println(order);
		jmsTemplate.convertAndSend(queue, order);
		return order + " sent";
	}
}
