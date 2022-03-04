package com.abcbank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.bean.Account;
import com.abcbank.config.MySecurityConfigurationDb;
import com.abcbank.repo.AccountRepo;



@Service
public class CustomerService {

	@Autowired
	private AccountRepo accRepo;

	public List<Account> getAllAccounts(long custId)
	{

		List<Account> accounts = accRepo.findByCustomer(custId);

		return accounts;
	}

	@Autowired
	private MySecurityConfigurationDb config;
	
	public Account getAccount(long accountNo)
	{
		Optional<Account> accountOp = accRepo.findById(accountNo);
		if(accountOp.isPresent()) 
		{ 
			Account acc = accountOp.get();
			acc.setPort(config.getPort());
			System.out.println(acc);
			return acc;}


		return null;
	}

	public String withdraw(long accountNo,double amount)
	{
		Optional<Account> accountOp = accRepo.findById(accountNo);
		Account account =accountOp.get();
		double balance = account.getBalance();

		if(accountOp.isPresent() && account.getBalance() > amount - 1000)
		{
			account.setBalance(amount);
			accRepo.save(account);
			return "updated: Balance="+balance;
		}
		return "Not updated:"+balance;

	}

}
