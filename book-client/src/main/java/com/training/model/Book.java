package com.training.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

//@Table(name="booknew")
public class Book {
	
	private Long isbn;
	private String title;
	private Double price;
	private Long stock;

}
