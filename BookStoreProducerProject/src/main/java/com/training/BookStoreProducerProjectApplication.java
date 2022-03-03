package com.training;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.Book;
import com.training.repo.BookRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "BookStore API", version = "1.0", description = "Books Information"))
@SpringBootApplication
public class BookStoreProducerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreProducerProjectApplication.class, args);
	}
	
	@Autowired
	private BookRepo bookRepo;
	
	
	/*
	 * @PostConstruct public void addBooks() { bookRepo.save(new Book(1234, "C",
	 * 150.25, 100)); bookRepo.save(new Book(2345, "CPlus", 250.25, 100));
	 * bookRepo.save(new Book(9732, "Python",3150.25, 100)); }
	 */
	 

	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			// update a book
			
			  Optional<Book> opBook = bookRepo.findById(1234l); if(opBook.isPresent()) {
			  Book updatedBook = opBook.get();
			  updatedBook.setStock(updatedBook.getStock()+50); bookRepo.save(updatedBook);
			  }
			 
			
			// get Books based on title
			
			  System.out.println(bookRepo.findByTitle("C"));
			  
			  System.out.println(bookRepo.findByTitleLike("%C%"));
			  
			  System.out.println(bookRepo.getBooksTitle("C"));
			  
			  System.out.println(bookRepo.findByPriceAndStock(150.25, 100));
			  
			  System.out.println(bookRepo.findByPriceAndStockC(200,80));
			 
			
			System.out.println(bookRepo.updateStockBooks(50, 150));
			
		};
	}
	
	
	

}
