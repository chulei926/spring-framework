package com.leichu.spring.learn.mybatis;

import com.leichu.spring.learn.mybatis.config.MainConfig;
import com.leichu.spring.learn.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBatisTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		System.out.println(userService.getList());

		ctx.close();
	}


}
