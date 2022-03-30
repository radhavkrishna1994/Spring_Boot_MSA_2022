package com.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderedBook {

	private Long isbn;
	private String title;
	private Double price;
	private Long stock;
	private int quantity;
	private Double amount;
	private int port;
}
