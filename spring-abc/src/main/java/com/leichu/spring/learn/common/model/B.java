package com.leichu.spring.learn.common.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	@Autowired
	A a;

	public B() {
		System.out.println(">>>>>>>>>> 无参构造器 开始实例化 B .");
	}

	private int id;

	public B(int id) {
		System.out.println(">>>>>>>>>> 有参构造器 开始实例化 B .");
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println(">>>>>>>>>> B.setter 方法 设置 id .");
		this.id = id;
	}

//	public B(A a) {
//		this.a = a;
//	}

	public void sayHello() {
		System.out.println(">>>>>>>>>> Hello ! I am B.");
	}
}
