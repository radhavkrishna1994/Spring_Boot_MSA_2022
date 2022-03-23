package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.User;
import com.training.data.UserData;

import reactor.core.publisher.Flux;

@Service
public class UserService {

	@Autowired
	private UserData userData;
	
	public List<User> getUsers()
	{
		long start = System.currentTimeMillis();
		List<User> users = userData.getUsers();
		long end = System.currentTimeMillis();
		System.out.println("Time Taken:"+(end-start));
		return users;
	}
	
	public Flux<User> getUsersStream()
	{
		long start = System.currentTimeMillis();
		Flux<User> users = userData.getUsersStream();
		long end = System.currentTimeMillis();
		System.out.println("Time Taken:"+(end-start));
		return users;
	}
}
