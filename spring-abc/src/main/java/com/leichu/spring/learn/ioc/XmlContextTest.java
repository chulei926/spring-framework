package com.leichu.spring.learn.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContextTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		ctx.start();
	}
}
