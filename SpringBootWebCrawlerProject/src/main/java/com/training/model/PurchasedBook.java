package com.training.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PurchasedBook {

	
	private String isbn;
	private String title;
	private double price; //Double
	private long stock;
	private long qty;
	private double amount;
}
