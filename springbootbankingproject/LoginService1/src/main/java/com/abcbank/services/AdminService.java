package com.abcbank.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abcbank.bean.Account;
import com.abcbank.bean.Customer;
import com.abcbank.bean.MyUser;
import com.abcbank.repo.AccountRepo;
import com.abcbank.repo.CustomerRepo;
import com.abcbank.repo.UserRepo;


@Service
public class AdminService {
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private AccountRepo accRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Transactional
	public Customer createCustomer(Customer customer)
	{
		MyUser newUser = new MyUser();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(getPassword("abcd"));
		newUser.setActive(true);
		newUser.setRoles("ROLE_CUSTOMER");
		userRepo.save(newUser);
		return custRepo.save(customer);
	}
	
	public String getPassword(String password)
	{
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
	
		return hashedPassword;
	}
	public Account createAccount(Account account, long custId)
	{
		account.setCustomer(custRepo.findById(custId).get());
		return accRepo.save(account);
	}
	
	
	public boolean deleteAccount(long accNo)
	{
		Optional<Account> acc = accRepo.findById(accNo);
		if(acc.isPresent())
		{	accRepo.delete(acc.get());
			return true;
		
		}
		return false;
	}

}
