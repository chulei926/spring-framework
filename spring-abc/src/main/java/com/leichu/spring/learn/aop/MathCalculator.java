package com.leichu.spring.learn.aop;

public class MathCalculator {

	MathCalculator() {
		System.out.println("---> MathCalculator contractor ......");
	}

	public int add(int a, int b) {
		return a + b;
	}

//	public int div(int a, int b) {
//		return a / b;
//	}

}
