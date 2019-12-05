package com.leichu.spring.learn.ioc;

import com.leichu.spring.learn.common.model.Animal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContextTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Animal animal = ctx.getBean(Animal.class);
		animal.say();
		ctx.close();
	}
}
