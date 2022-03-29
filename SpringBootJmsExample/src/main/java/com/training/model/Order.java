package com.training.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order implements Serializable{
	//private static final long serialVersionUID = 1L;
	private long orderId;
	private String customerName;
	private double amount;


}
