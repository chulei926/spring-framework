package com.leichu.spring.learn.ioc.config;

import com.leichu.spring.learn.common.model.User;
import com.leichu.spring.learn.ioc.custom.MyBeanFactoryPostProcessor;
import com.leichu.spring.learn.ioc.custom.MyBeanPostProcessor;
import com.leichu.spring.learn.ioc.custom.UserFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.leichu")
public class AnnotationConfig {

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
		user.say();
		return user;
	}
}
