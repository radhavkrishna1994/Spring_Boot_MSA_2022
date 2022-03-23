package com.training.controllers;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.User;
import com.training.data.UserData;
import com.training.services.UserService;

import reactor.core.publisher.Flux;
import java.util.stream.Collectors;
@RestController
public class TestController {
	

	@GetMapping("/sayflux")
	public Flux<Integer> sayHelloFlux()
	{
		return Flux.just(1,2,3,4)
				.delayElements(Duration.ofSeconds(2))
				.log();
	}
	
	@GetMapping(value="/sayfluxagain",produces = MediaType.TEXT_EVENT_STREAM_VALUE )
	public Flux<Integer> sayHelloFluxAgain()
	{
		return Flux.just(1,2,3,4)
				.delayElements(Duration.ofSeconds(1))
				.log();
	}
	
	@Autowired
	private UserService userService;

	@GetMapping("/getusers")
	public List<User> getUsers()
	{
		
		return userService.getUsers();
		
	}
	
	@GetMapping(value="/getusersstream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersStream()
	{
		return userService.getUsersStream();
	}
	
	
}
