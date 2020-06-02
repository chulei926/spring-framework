package com.leichu.spring.learn.bean;

import com.leichu.spring.learn.bean.custom.*;
import com.leichu.spring.learn.common.model.A;
import com.leichu.spring.learn.common.model.B;
import com.leichu.spring.learn.common.model.User;
import com.leichu.spring.learn.common.model.color.Black;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

public class BeanTest4Annotation {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CircularDependenceAnnotationConfig.class);
//		User user = ctx.getBean(User.class);
//		System.out.println(user);
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println("---------- >  " + name);
//		}

//		UserService userService = ctx.getBean(UserService.class);
//		userService.say("leichu");
//
//		Student stu = ctx.getBean(Student.class);
//		System.out.println(stu);

		ctx.getBean(A.class).sayHello();
		ctx.getBean(B.class).sayHello();

		ctx.close();
	}


}

@Configurable
@ComponentScan({"com.leichu.spring.learn.common.model"})
class CircularDependenceAnnotationConfig {

	@Bean
	public A a() {
		return new A(1);
//		return new A(b());
	}

	@Bean
	public B b() {
		return new B(2);
//		return new B(a());
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