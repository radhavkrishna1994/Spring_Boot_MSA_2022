package com.training.aspects;

import org.springframework.http.HttpStatus;

public class MyAspectException extends RuntimeException {

	private String message;
	public String getMessage() {
		return message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	private HttpStatus statusCode;
	
	public MyAspectException(String message, HttpStatus statusCode) {
	this.message=message;
	this.statusCode=statusCode;
	}

	public String toString()
	{
		return message+" "+statusCode;
	}
}
