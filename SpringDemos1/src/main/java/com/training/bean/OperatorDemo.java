package com.training.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.interaces.Operator;

public class OperatorDemo {

	//@Autowired
	private Operator operator;

	public OperatorDemo(Operator operator)
	{
		this.operator=operator;
	}
	/*
	 * public void setOperator(Operator operator) { this.operator = operator; }
	 */
	
	public int getResult(int x,int y)
	{
		return operator.operate(x, y);
	}
	
}
