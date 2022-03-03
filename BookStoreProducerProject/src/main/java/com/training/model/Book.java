package com.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="books")
public class Book {  
	@Id                  // primary key
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long isbn;
	private String title;
	private double price;
	private long stock;
	private String author;
}


