package com.training.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.bean.Notification;
import com.training.bean.User;
import com.training.repo.NotificationRepo;
import com.training.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private NotificationService notificationService;
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED)
	public void addUser(User user,Notification not) 
	{
		//notificationService=null;
		userRepo.save(user);
		notificationService.addNotification(not);
			
	}
}
