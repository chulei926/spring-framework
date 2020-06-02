package com.leichu.spring.learn.mybatis.service.impl;

import com.leichu.spring.learn.mybatis.domain.User;
import com.leichu.spring.learn.mybatis.mapper.UserMapper;
import com.leichu.spring.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	@Transactional
	public List<User> getList() {
		User user = new User();
		user.setName("leichu");
		user.setPwd("leichu");
		userMapper.insert(user);
		userMapper.insert2(user);
		return userMapper.findList();
	}
}
