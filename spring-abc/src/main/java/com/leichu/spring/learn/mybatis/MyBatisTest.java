package com.leichu.spring.learn.mybatis;

import com.leichu.spring.learn.mybatis.config.MainConfig;
import com.leichu.spring.learn.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBatisTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

		ctx.getBean(UserService.class).getList();

		ctx.close();
	}


}
