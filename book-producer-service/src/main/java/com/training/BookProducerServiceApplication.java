package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.Book;
import com.training.repo.BookRepo;

@EnableDiscoveryClient
@SpringBootApplication
public class BookProducerServiceApplication {//implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookProducerServiceApplication.class, args);
	}

	
	@Autowired
	private BookRepo bookRepo;
	
	
	
	  @PostConstruct public void init() { 
		  bookRepo.save(new Book(1234l, "C",150.25, 100l,0)); bookRepo.save(new Book(5678l, "CPlus", 170.25, 100l,0));
	  bookRepo.save(new Book(7891l, "Python", 120.25, 100l,0));
	  
	  }
	 
	
	//CommandLine Runner  java 8
	
	/*
	 * @Bean public CommandLineRunner getRunner(ApplicationContext ctx) { return
	 * args->{
	 * 
	 * System.out.println(bookRepo.findByTitle("C"));
	 * System.out.println(bookRepo.findByTitleAndStock("C",100l));
	 * 
	 * System.out.println(bookRepo.getBookOnTitle("CSharp"));
	 * 
	 * System.out.println(bookRepo.getBookOnTitleLike("%CS%"));
	 * 
	 * System.out.println(bookRepo.findByPriceLessThan(150.0));
	 * 
	 * System.out.println(bookRepo.updateStockOnTitle("Python", 75l)); }; }
	 */
	
}







