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

	/**
	 * 是否是单例？
	 * true：单例，在容器中只保留一份
	 * false：非单例，每次获取的时候重新创建一个新的 bean。就是调用上面的 getObject()方法进行创建。
	 * @return
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}
}
