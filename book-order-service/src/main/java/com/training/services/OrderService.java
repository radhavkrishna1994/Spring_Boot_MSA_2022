package com.training.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.config.OrderConfiguration;
import com.training.interfaces.BookFeignProxy;
import com.training.model.OrderedBook;

@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderConfiguration orderConfiguration;
	
	public OrderedBook createOrderBook(Long isbn,int quantity)
	{
		String producerUrl= orderConfiguration.getServiceUrl();
		
		HashMap<String,String> map = new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		
		OrderedBook orderedBook = restTemplate.getForObject(producerUrl, OrderedBook.class, map );
		orderedBook.setQuantity(quantity);
		orderedBook.setAmount(orderedBook.getPrice() * quantity);
		
		return orderedBook;
	}
	
	@Autowired
	private BookFeignProxy proxy;
	
	public OrderedBook createOrderBookFeign(Long isbn,int quantity)
	{
		OrderedBook orderedBook = proxy.getOrderBook(isbn);
		orderedBook.setQuantity(quantity);
		orderedBook.setAmount(orderedBook.getPrice() * quantity);
		
		return orderedBook;
	}
	
	
}
