package com.leichu.spring.learn.ioc;

import com.leichu.spring.learn.common.model.Animal;
import com.leichu.spring.learn.common.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.leichu")
public class AnnotationContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationContextTest.class);
		try {
			ctx.getBean(User.class).say();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * 自定义 MyBeanFactoryPostProcessors 之后，将 User 的 BeanDefinition 改成了 Animal.
		 * 所以 ctx.getBean(User.class) 会抛出 NoSuchBeanDefinitionException 异常。
		 * 而 Animal 没有加 注解 反而获取到了。
		 */
		try {
//			ctx.getBean(Animal.class).say();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
