package com.leichu.spring.learn.ioc;

import com.leichu.spring.learn.common.model.User;
import com.leichu.spring.learn.ioc.config.AnnotationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println("BeanDefinitionName -------------> " + name);
//		}
		((AnnotationConfigApplicationContext) ctx).close();
//		Object user1 = ctx.getBean("&userFactoryBean");
//		Object user2 = ctx.getBean("userFactoryBean");
//		System.out.println(user1);
//		System.out.println(user2);
//		System.out.println(user1 == user2);


//		try {
//			ctx.getBean(User.class).say();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/**
		 * 自定义 MyBeanFactoryPostProcessors 之后，将 User 的 BeanDefinition 改成了 Animal.
		 * 所以 ctx.getBean(User.class) 会抛出 NoSuchBeanDefinitionException 异常。
		 * 而 Animal 没有加 注解 反而获取到了。
		 */
//		try {
////			ctx.getBean(Animal.class).say();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
