package com.training;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.Account;
import com.training.model.Book;
import com.training.model.Customer;
import com.training.repo.BookRepo;
import com.training.repo.CustomerRepo;

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
	 
	@Autowired
	private CustomerRepo custRepo;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			// update a book
			
			/*
			 * Optional<Book> opBook = bookRepo.findById(1234l); if(opBook.isPresent()) {
			 * Book updatedBook = opBook.get();
			 * updatedBook.setStock(updatedBook.getStock()+50); bookRepo.save(updatedBook);
			 * }
			 * 
			 * 
			 * // get Books based on title
			 * 
			 * System.out.println(bookRepo.findByTitle("C"));
			 * 
			 * System.out.println(bookRepo.findByTitleLike("%C%"));
			 * 
			 * System.out.println(bookRepo.getBooksTitle("C"));
			 * 
			 * System.out.println(bookRepo.findByPriceAndStock(150.25, 100));
			 * 
			 * System.out.println(bookRepo.findByPriceAndStockC(200,80));
			 * 
			 * 
			 * System.out.println(bookRepo.updateStockBooks(50, 150));
			 */
			
			
			/*
			 * Account account1=new Account();
			 * 
			 * account1.setBalance(1000); account1.setDoa(LocalDate.now());
			 * 
			 * Account account2=new Account(); account2.setBalance(1000);
			 * account2.setDoa(LocalDate.now());
			 * 
			 * Customer customer = new Customer(); customer.setName("sam"); LocalDate dob =
			 * LocalDate.parse("1988-04-05"); customer.setDob(dob);
			 * 
			 * 
			 * account1.setCustomer(customer); account1.setAccountType("SB");
			 * 
			 * account2.setCustomer(customer); account2.setAccountType("Current");
			 * 
			 * List<Account> accounts = Arrays.asList(account1,account2);
			 * 
			 * customer.setAccounts(accounts); custRepo.save(customer);
			 */
			
			Customer customer = custRepo.findById(1l).get();
			System.out.println(customer);
			System.out.println(customer.getAccounts());
			
		};
	}
	
	
	

}
