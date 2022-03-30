package com.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name="booknew")
public class Book {
	
	@Id  // Primary key
	private Long isbn;
	private String title;
	private Double price;
	private Long stock;

}
