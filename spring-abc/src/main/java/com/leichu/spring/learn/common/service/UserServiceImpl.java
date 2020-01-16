package com.leichu.spring.learn.common.service;

import com.leichu.spring.learn.common.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void say(String name) {
		System.out.println(userDao);
		System.out.println("Hello " + name);
	}
}
