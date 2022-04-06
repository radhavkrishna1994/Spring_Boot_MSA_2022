package com.training.bean;

import com.training.interfaces.Operator;

public class AddOperator implements Operator {

	@Override
	public void operate(int x, int y) {
		System.out.println("Sum:"+(x+y));

	}

}
