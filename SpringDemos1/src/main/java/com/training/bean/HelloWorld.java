package com.training.bean;

public class HelloWorld {

	private String message;
	private int n;

	public void setMessage(String message) {
		this.message = message;
	}

	public void setN(int n) {
		this.n = n;
	}

	public HelloWorld() { }
	
	public HelloWorld(String message,int n) // Constructor Ijection 
	{
		//System.out.println("Message injected.."); 
		this.message=message; this.n=n; 
	}

	public String sayHello()
	{
		return message+" "+n;
	}
}
