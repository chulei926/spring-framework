package com.leichu.spring.learn.bean.custom;

import com.leichu.spring.learn.common.model.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User("张三", 30);
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
