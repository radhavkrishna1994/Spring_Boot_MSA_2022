package com.training.exceptions;

public class UserNotFoundException extends Exception {

	private String message;
	public String getMessage() {
		return message;
	}
	public UserNotFoundException(String message) {
		this.message=message;
	}
	
	
}
