package com.leichu.spring.learn.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopAnnotationConfig.class);

		ctx.getBean(MathCalculator.class).add(1, 2);
		try {
			ctx.getBean(MathCalculator.class).div(2, 0);
		} catch (Exception e){
			System.err.println(e);
		}


	}

}
