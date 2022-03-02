package com.training.classes;

public class HelloWorld {
		
	class Demo
	{
		private int num;
	}
	
	private String message;
	
	public HelloWorld() { }
	
	/*
	 * public HelloWorld(String message) //Constructor Injection {
	 * this.message=message; }
	 */
	
	public void setMessage(String message) // Setter Injection
	{
		this.message=message;
	}
	
	public String sayHello()
	{
		return message;
	}

}
