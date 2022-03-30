package com.training.interfaces;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.model.OrderedBook;

@FeignClient(name="book-producer-service")
@LoadBalancerClient(name="book-producer-service")
public interface BookFeignProxy {
	
	@GetMapping("/bookstore/book/isbn/{isbn}")
	public OrderedBook getOrderBook(@PathVariable("isbn") Long isbn);

}





