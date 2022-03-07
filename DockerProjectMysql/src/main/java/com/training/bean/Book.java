package com.training.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class Book implements Serializable{ 
	@Id
	private String isbn;
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private double price;
	
	@Column(name="stock")
	private long stock;
	
	
}
