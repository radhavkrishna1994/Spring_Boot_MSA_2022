package com.training.data;

import java.time.Duration;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.training.bean.User;

import reactor.core.publisher.Flux;

@Repository
public class UserData {

	public Flux<User> getUsersStream()
	{
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("Processing..."+i))
				.map(i->new User(i, "User:"+i))
				.log();
		
			
	}

	
	public List<User> getUsers()
	{
		return IntStream.rangeClosed(1, 10)
		.peek(UserData::sleepThread)
		.peek(i->System.out.println("processing:"+i))
		.mapToObj(i->new User(i, "User"+i))
		.collect(Collectors.toList());
		
		
	}

	private static void sleepThread(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
