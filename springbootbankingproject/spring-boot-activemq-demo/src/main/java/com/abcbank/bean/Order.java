package com.abcbank.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;




@Component
public class Order implements Serializable {

	private int orderId;
	private String name;
	public Order(int orderId, String name) {
		super();
		this.orderId = orderId;
		this.name = name;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return orderId+" "+name;
	}
	
	
}
