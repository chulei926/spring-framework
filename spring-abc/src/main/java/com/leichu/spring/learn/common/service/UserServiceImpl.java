package com.leichu.spring.learn.common.service;

import org.springframework.stereotype.Service;

//@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public void say(String name) {
		System.out.println("Hello " + name);
	}
}
