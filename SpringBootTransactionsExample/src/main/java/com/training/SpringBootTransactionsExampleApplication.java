package com.training;


import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.User;
import com.training.bean.Notification;
import com.training.services.NotificationService;
import com.training.services.UserService;

@SpringBootApplication
@RestController
public class SpringBootTransactionsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionsExampleApplication.class, args);
	}

	@Autowired
	private UserService userService;
	
	@Autowired
	private NotificationService notService;
	/*
	 * @PostConstruct public void start() throws Exception { User user1 = new
	 * User("user1@gmail.com", "user1", LocalDate.now()); Notification n1=new
	 * Notification(); n1.setEmail(null); n1.setMessage("welcome");
	 * 
	 * userService.addUser(user1, n1); }
	 */
	
	@GetMapping("/adduser")
	public void addUser()
	{
		User user1 = new User("user1@gmail.com", "user1", LocalDate.now());
		Notification n1=new Notification();
		n1.setEmail("user1@gmail.com");
		n1.setMessage("welcome");
		
		userService.addUser(user1, n1);
	}
	
	@GetMapping("/addnot")
	public void addNot()
	{
		Notification n1=new Notification();
		n1.setEmail("user1@gmail.com");
		n1.setMessage("welcome");
		
		notService.addNotification(n1);
	}
	
}
