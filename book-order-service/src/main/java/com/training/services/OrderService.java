package com.training.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.config.OrderConfiguration;
import com.training.model.OrderedBook;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//private String producer_url = "http://localhost:8083/bookstore/book/isbn/{isbn}";
	
	@Autowired
	private OrderConfiguration orderConfig;
	
	public OrderedBook createOrderBook(long isbn,int qty)
	{
		String producer_url = orderConfig.getServiceUrl();
		
		HashMap<String,String> map=new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		OrderedBook orderedBook = restTemplate.getForObject(producer_url, OrderedBook.class, map);
		if(orderedBook.getStock() > qty)
		{
		orderedBook.setQty(qty);
		orderedBook.setAmount(orderedBook.getPrice() * qty);
		}
		
		return orderedBook;
	}

}





