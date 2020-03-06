package com.leichu.spring.learn.bean;

import com.leichu.spring.learn.bean.custom.*;
import com.leichu.spring.learn.common.model.Student;
import com.leichu.spring.learn.common.model.User;
import com.leichu.spring.learn.common.model.color.Black;
import com.leichu.spring.learn.common.service.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.*;

public class BeanTest4Annotation {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
//		User user = ctx.getBean(User.class);
//		System.out.println(user);
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("---------- >  " + name);
		}

//		UserService userService = ctx.getBean(UserService.class);
//		userService.say("leichu");
//
//		Student stu = ctx.getBean(Student.class);
//		System.out.println(stu);

		ctx.close();
	}


}

@Configurable
@ComponentScan({"com.leichu.spring.learn.common.service", "com.leichu.spring.learn.common.dao"})
@Import({Black.class, MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
class AnnotationConfig {

	@Bean
	public InstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor() {
		return new MyInstantiationAwareBeanPostProcessor();
	}

	//@Bean
	//public FactoryBean<User> userFactoryBean() {
	//	return new UserFactoryBean();
	//}

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