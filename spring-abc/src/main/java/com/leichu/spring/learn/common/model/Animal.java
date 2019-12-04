package com.leichu.spring.learn.common.model;

import org.springframework.stereotype.Component;

//@Component
public class Animal {
	private String name;

	public Animal(){
		System.out.println("------------- Animal init -------------");
	}

	public void say(){
		System.err.println(" ==================== hello animal ==================== ");
	}
}
