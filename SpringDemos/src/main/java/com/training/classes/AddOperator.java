package com.training.classes;

import com.training.interfaces.Operator;

public class AddOperator implements Operator {

	@Override
	public int operate(int x, int y) {
		
		return x+y;
	}

}
