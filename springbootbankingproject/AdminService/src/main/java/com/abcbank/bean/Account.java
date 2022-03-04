package com.abcbank.bean;

import java.time.LocalDate;
import java.util.Date;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;*/

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class Account {
	
	
	private long accountNo;
	
	private double balance;
	
	
	private String accountType;
	private LocalDate doa;
	
	
	private Customer customer;
	

	public String toString()
	{
		return accountNo+" "+balance+" "+doa;
	}
}
