package com.leichu.spring.learn.bean;

import com.leichu.spring.learn.common.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest4XML {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		User user = ctx.getBean(User.class);
		System.out.println(user);
		ctx.close();
	}
}
