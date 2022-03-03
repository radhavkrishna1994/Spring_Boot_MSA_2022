package com.training.aspects;

import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@Aspect
public class BookAspect {
	
	Logger log = LoggerFactory.getLogger(BookAspect.class);

	@Before(value = "execution(* com.training.services.BookService.get*(..))")
	public void logBefore(JoinPoint joinPoint)
	{
		String className =  joinPoint.getClass().getName();
		//String methodName = joinPoint.getSignature().getName();
		log.info(className);
		log.info("Executes Before method");
		log.info("This is a Log:"+new Date());
	}
	
	@Around(value = "execution(* com.training.*.*.get*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) 
	{
		String className =  joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		log.info("Class Name:"+className);
		log.info("Method name:"+methodName);;
		log.info("Executes Before method");
		log.info("This is a Log:"+new Date());
		Object value="";
		try {
			value = joinPoint.proceed();
			if(value==null)
				throw new MyAspectException("Value Not accepted",HttpStatus.NOT_ACCEPTABLE);
		} 
		catch(MyAspectException e)
		{
			log.info(e.getMessage()+" "+e.getStatusCode());
			
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				log.info("Value :"+mapper.writeValueAsString(value));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
					
			
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	
}
