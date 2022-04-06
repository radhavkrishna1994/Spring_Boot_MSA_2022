package com.training.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.training.interfaces.MyInterface;
import com.training.interfaces.Operator;

public class OperatorDemo {
	
	//inject Operator 
	@Qualifier("op")
	@Autowired
	private Operator operator;
	
	
	//private MyInterface test;
	
	
	/*
	 * public void setTest(MyInterface test) { this.test = test; }
	 */

	public OperatorDemo()
	{
		System.out.println("Constructor..");
	}

	/*
	 * public void setOperator(Operator operator) {
	 * 
	 * System.out.println("calling setter.."); this.operator = operator; }
	 */
	
	public void printResult(int x,int y)
	{
		operator.operate(x, y);
	}

}
