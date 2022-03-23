package com.training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.training.bean.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@EnableScheduling
@SpringBootApplication
public class SpringBootReactiveWebDemo1Application  {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveWebDemo1Application.class, args);
	}

	@Bean
	CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			//Flux.empty();
			Flux<Integer> integers = Flux.just(5,6,7,8);
			integers.doOnNext(i->System.out.print(i+" ")).subscribe();
			
			/*
			 * Flux.range(1,5).subscribe( succcessValue->System.out.println(succcessValue),
			 * error->System.out.print(error), ()->System.out.print("consumed"));
			 */
			  Mono<User> user = Mono.just(new User(0, "sam"));
			  user.subscribe(u->System.out.print(u));
			
		};
	}
}
