package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.exceptions.UserNotFoundException;
import com.training.model.User;
import com.training.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void saveUser(User user)
	{
		userRepo.save(user);
	}
	
	public User findByUserId(Long userId) throws UserNotFoundException 
	{
		User userFound = userRepo.findByUserId(userId);
		if(userFound==null)
			throw new UserNotFoundException("User Not Found ");
		else
		return userFound; 
	}
}








