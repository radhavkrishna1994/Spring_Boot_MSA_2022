package com.training.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.training.exceptions.UserNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler
{
	
	//MethodArgumentNotValidException
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> InValidArgumentHandler(MethodArgumentNotValidException ex)
	{
		Map<String,String> errMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().
		forEach(error->errMap.put(error.getField(), error.getDefaultMessage()));
		
		return errMap;
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> UserNotFoundException(UserNotFoundException ex)
	{
		Map<String,String> errMap = new HashMap<>();
		errMap.put("message", ex.getMessage());
		
		return errMap;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String noHandlerFoundExceptionMethod(NoHandlerFoundException ex)
	{
			
		return "Path not Valid";
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String noHandlerFoundExceptionMethod1(MethodArgumentTypeMismatchException ex)
	{
			
		return "Path Id Value of type Long Expected";
	}
	
	
}





