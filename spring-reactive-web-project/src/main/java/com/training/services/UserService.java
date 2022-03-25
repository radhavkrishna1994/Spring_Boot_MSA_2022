package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.data.UserData;
import com.training.model.User;
import com.training.repo.UserRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	private UserData userData;
	
	public List<User> getUsers()
	{
		return userData.getUsers();
	}
	
	public Flux<User> getUsersStream()
	{
		return userData.getUsersStream();
	}

	@Autowired
	private UserRepo userRepo;
	
	public Flux<User> getUsersStreamDb()
	{
		return userRepo.findAll();
	}
	
	public void createUser(User user)
	{
		userRepo.save(user).subscribe();
	}
	
	public Mono<User> getUserStreamDb(int id)
	{
		return userRepo.findById(id);
	}
}
