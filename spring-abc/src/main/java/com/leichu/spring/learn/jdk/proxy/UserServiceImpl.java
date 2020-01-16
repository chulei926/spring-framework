package com.leichu.spring.learn.jdk.proxy;

public class UserServiceImpl implements UserService {

	@Override
	public String say() {
		System.out.println("hello leichu");
		return "success";
	}

}
