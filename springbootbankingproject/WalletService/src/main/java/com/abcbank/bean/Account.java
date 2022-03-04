package com.abcbank.bean;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Account {
	
	
	private long accountNo;
	
	private double balance;
	private int port;
	
	
	private String accountType;
	private LocalDate doa;
	
	
	//private Customer customer;
	

	public String toString()
	{
		return accountNo+" "+balance+" "+doa;
	}
}
