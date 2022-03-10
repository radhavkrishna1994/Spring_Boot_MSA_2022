package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchJpaExampleApplication.class, args);
	}

	@Autowired
	private Scheduler sch;
	
	@Bean
	CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			sch.cronJobSch();
		};
	}
}
