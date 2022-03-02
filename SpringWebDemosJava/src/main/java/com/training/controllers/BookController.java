package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	
	//http://localhost:8080/SpringWebDemos/sayhello
	@RequestMapping(value="/sayhello",method = RequestMethod.GET)
	@ResponseBody
	public String sayHello()
	{
		// call business logic -- data  (model)
		// to view
		return "Hello Spring MVC Application";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String start()
	{
		
		return "index.jsp";
	}
	
	//http://localhost:8080/SpringWebDemos/home?username=sam&email=sam@gmail.com
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String sayHelloView(
			@RequestParam("username") String username,@RequestParam("email") String email,
			ModelMap map)
	{
		map.addAttribute("username", username);
		map.addAttribute("email", email);
		return "home.jsp";
	}


}





