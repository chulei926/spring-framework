package com.leichu.spring.learn.mybatis.service.impl;

import com.leichu.spring.learn.mybatis.domain.User;
import com.leichu.spring.learn.mybatis.mapper.UserMapper;
import com.leichu.spring.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getList() {
		userMapper.findList();
		return null;
	}
}
