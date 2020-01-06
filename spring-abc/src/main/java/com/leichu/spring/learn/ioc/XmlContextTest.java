package com.leichu.spring.learn.ioc;

import com.leichu.spring.learn.common.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContextTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println("BeanDefinitionName -------------> " + name);
//		}
		User user = ctx.getBean(User.class);
		System.out.println(user);
//		ctx.close();
	}
}
