package com.training.services;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Service
public class MessageService {

	@Autowired
	public JmsTemplate jmsTemplate;
	
	@Autowired
	public Queue queue;
	
	public String publishMessage(String message)
	{
		jmsTemplate.convertAndSend(queue, message);
		return message+" published";
	}
	
	
	public String publishOrder(Order order)
	{
		jmsTemplate.convertAndSend(queue, order);
		return order+" published";
	}
	
	
}

