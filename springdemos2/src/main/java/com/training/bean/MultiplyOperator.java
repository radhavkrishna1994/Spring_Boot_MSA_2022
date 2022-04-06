package com.training.bean;

import com.training.interfaces.Operator;

public class MultiplyOperator implements Operator {

	@Override
	public void operate(int x, int y) {
		System.out.println("Result:"+(x*y));

	}

}
