package com.leichu.spring.learn.ioc;

import com.leichu.spring.learn.common.model.User;
import com.leichu.spring.learn.ioc.custom.MyBeanFactoryPostProcessor;
import com.leichu.spring.learn.ioc.custom.MyBeanPostProcessor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

public class AnnotationContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		User user = ctx.getBean(User.class);
		System.out.println(user);
		ctx.close();
	}
}

@Configurable
@ComponentScan("com.leichu")
class AnnotationConfig {

//	@Bean
//	public FactoryBean<User> userFactoryBean() {
//		return new UserFactoryBean();
//	}

	@Bean
	public BeanFactoryPostProcessor myBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}

	@Bean
	public BeanPostProcessor myBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}

	@Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	public User user() {
		User user = new User();
		user.setName("张三");
		user.setAge(20);
		return user;
	}
}
