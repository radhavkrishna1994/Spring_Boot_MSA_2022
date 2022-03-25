package com.training.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.Duration;
import org.springframework.stereotype.Component;

import com.training.model.User;


import reactor.core.publisher.Flux;

@Component
public class UserData {
		
	public List<User> getUsers()
	{
		return IntStream.range(1, 8)
				.peek(UserData::sleepThread)
				.peek(i->System.out.println("Processing: "+ i))
				.mapToObj(i->new User(i, "user"+i, "User"+i+"@gmail.com"))
				.collect(Collectors.toList());
	}
	
	
	//reactive
	public Flux<User> getUsersStream()
	{
		return Flux.range(1, 8)
		    .delayElements(Duration.ofSeconds(2))
		    .doOnNext(i->System.out.println("processing..: "+i))
		    .map(i->new User(i, "user"+i, "User"+i+"@gmail.com"))
		    .log();
		    
		
	}
	
	private static void sleepThread(int i)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
