package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.bean.Notification;
import com.training.repo.NotificationRepo;
import com.training.repo.UserRepo;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepo notificationRepo;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotification(Notification not)
	{
		notificationRepo.save(not);
	}
}
