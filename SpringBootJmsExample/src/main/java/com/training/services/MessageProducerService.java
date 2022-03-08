package com.training.services;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.model.Order;

@Service
public class MessageProducerService {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	
	public String postMessage(String message)
	{
		jmsTemplate.convertAndSend(queue, message);
		return message+" published";
	}
	
	public String postOrders(List<Order> orders)
	{
		
		jmsTemplate.convertAndSend(queue, orders);
		return orders + " Published";
	}
	
	public String postOrder(Order order)
	{
		
		jmsTemplate.convertAndSend(queue, order);
		return order + " Published";
	}
	
}
