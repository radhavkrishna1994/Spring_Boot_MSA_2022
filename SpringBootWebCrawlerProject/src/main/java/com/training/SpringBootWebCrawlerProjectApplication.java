package com.training;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.PurchasedBook;
import com.training.model.PurchasedBookListClass;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringBootWebCrawlerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebCrawlerProjectApplication.class, args);
	}

	@Autowired
	private WebClientService webClientService;
	
	@Bean
	CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			webClientService.crawlMovies();
			//webClientService.crawlDomains("facebook");
			
	};
}
}
