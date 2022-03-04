package com.abcbank.bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data

public class Customer {

	
	private long custId;
	
	private String name;
	private String username;
	
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	
	
//	private List<Account> accounts;
	
	public String toString()
	{
		return custId+" "+name+" "+dob;
	}
}
