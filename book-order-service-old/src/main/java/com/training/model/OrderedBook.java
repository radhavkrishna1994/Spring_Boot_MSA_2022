package com.training.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderedBook {  
	
	private long isbn;
	private String title;
	private double price;
	private long stock;
	private int qty;
	private double amount;
}
