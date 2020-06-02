package com.leichu.spring.learn.common.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Autowired
	B b;

	public A() {
		System.out.println(">>>>>>>>>> 无参构造器 开始实例化 A .");
	}

	private int id;

	public A(int id) {
		System.out.println(">>>>>>>>>> 有参构造器 开始实例化 A .");
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println(">>>>>>>>>> A.setter 方法 设置 id .");
		this.id = id;
	}


	//	public A(B b){
//		this.b = b;
//	}
	public void sayHello() {
		System.out.println(">>>>>>>>>> Hello ! I am A.");
	}


}
