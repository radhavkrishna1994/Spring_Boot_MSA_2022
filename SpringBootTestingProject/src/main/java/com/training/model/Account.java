package com.training.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="account_no")
	private long accountNo;
	
	private double balance;
	
	@Column(name="account_type")
	private String accountType;
	private LocalDate doa;
	
	
	@ManyToOne(fetch = FetchType.LAZY)   // foreign key
	@JoinColumn(name = "custId")
	private Customer customer;
	

	public String toString()
	{
		return accountNo+" "+balance+" "+doa;
	}
	private int port;
}
