package com.training.classes;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.interfaces.Operator;

public class OperatorDemo {

	@Autowired
	private Operator operator;

	public OperatorDemo()
	{
		//System.out.println("Object Created..");
	}
	
	
	/*
	 * public void setOperator(Operator operator) {
	 * System.out.println("Setting operator.."); this.operator = operator; }
	 */
	 
	
	public int getResult(int x,int y)
	{
		return operator.operate(x, y);
	}
	
	
	public void start()
	{
		System.out.println("Start of the bean LC");
	}
}
