package com.abcbank;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.abcbank.bean.Account;
import com.abcbank.bean.Customer;
import com.abcbank.repo.CustomerRepo;



//@EnableEurekaClient
@SpringBootApplication
public class LoginService1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LoginService1Application.class, args);
	}

	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Account account1=new Account();
		
		  
		  account1.setBalance(1000); account1.setDoa(LocalDate.now()); Account
		  account2=new Account(); account2.setBalance(1000);
		  account2.setDoa(LocalDate.now()); Customer customer = new Customer();
		  customer.setName("sam"); LocalDate dob = LocalDate.parse("1988-04-05");
		  customer.setDob(dob);
		  
		  account1.setCustomer(customer); account1.setAccountType("SB");
		  
		  account2.setCustomer(customer); account2.setAccountType("Current");
		  
		  List<Account> accounts = Arrays.asList(account1,account2);
		  
		  customer.setAccounts(accounts); custRepo.save(customer);
		 
		
	}

}
