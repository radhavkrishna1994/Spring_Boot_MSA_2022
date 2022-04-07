package com.training.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.exceptions.UserNotFoundException;
import com.training.model.User;
import com.training.repo.UserRepo;
import com.training.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public void saveUser(@RequestBody @Valid User user)
	{
		userService.saveUser(user);
	}
	@GetMapping("/userid/{userid}")
	public User getUser(@PathVariable("userid") Long userId) throws UserNotFoundException
	{
		return userService.findByUserId(userId);
	}
}
