package com.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="isbn",length = 100)
	private String isbn;
	
	@Column(name="title",nullable = false,length = 100)
	private String title;
	
	private double price;
	private long stock;

}



