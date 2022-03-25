package com.training.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.User;
import com.training.services.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@GetMapping(value = "/userstream",produces =MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersStream()
	{
		return userService.getUsersStream();
	}
	
	@GetMapping(value = "/userliststreamdb",produces =MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersListStreamDb()
	{
		return userService.getUsersStreamDb().log();
	}
	
	@GetMapping(value = "/userstreamdb/{id}")
	public Mono<User> getUserStreamDb(@PathVariable("id") int id)
	{
		return userService.getUserStreamDb(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public boolean createUser(@RequestBody User user)
	{
		try {
		userService.createUser(user);
		return true;
		}catch(Exception e)
		{
			return false;
		}
	}
 	 

}
