package com.abcbank.bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id")
	private long custId;
	
	private String name;
	private String username;
	
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	
	@OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL)
	private List<Account> accounts;
	
	public String toString()
	{
		return custId+" "+name+" "+dob;
	}
}
