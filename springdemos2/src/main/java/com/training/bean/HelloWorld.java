package com.training.bean;

public class HelloWorld {
	
	private String message;
	
	/*
	 * public HelloWorld(String message) // Constructor Injection {
	 * this.message=message; }
	 */
	
	public void init()
	{
		System.out.println("This is an Initializer");
	}
	
	public void setMessage(String message) // Setter Injection
	{
		this.message=message;
	}
	
	public String sayHello()
	{
		return message;
	}
	public void end()
	{
		System.out.println("This is a Destroy method");
	}
	
}
