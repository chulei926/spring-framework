package com.leichu.spring.learn.jdk.proxy;

public class StudentServiceImpl implements StudentService {

	@Override
	public String sayHello() {
		System.out.println("hello student");
		return "student success";
	}

}
