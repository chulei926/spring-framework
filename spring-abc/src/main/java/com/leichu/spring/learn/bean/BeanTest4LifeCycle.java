package com.leichu.spring.learn.bean;

import com.leichu.spring.learn.bean.custom.MyBeanPostProcessor;
import com.leichu.spring.learn.common.model.User;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 的声明周期： bean 创建 --->  初始化 --->  销毁。
 * <pre>
 * 1） bean 的创建：
 *      单例模式：在容器初始化时候进行创建，在容器中只有一份，整个生命周期由 容器进行管理。
 *      原型模式：在容器初始化时不创建，而是在 获取 bean 的时候才开始创建对象，容器关闭也不会销毁 多实例 bean。
 *      ---> 构造器
 *      ---> BeanNameAware.setBeanName
 *      ---> BeanFactoryAware.setBeanFactory
 *      ---> ApplicationContextAware.setApplicationContext
 * 2） bean 的初始化：
 *      ---> BeanPostProcessor.postProcessBeforeInitialization
 *      ---> PostConstruct
 *      ---> InitializingBean.afterPropertiesSet
 *      ---> initMethod
 *      ---> BeanPostProcessor.postProcessAfterInitialization
 * 3） bean 的销毁：
 *      ---> preDestroy
 *      ---> DisposableBean.destroy
 *      ---> destroyMethod
 *
 *  <pre>
 *  bean 初始化和销毁的 几种方式：
 *      1） 指定 initMethod 或 destroyMethod 方法
 *      2） 实现 InitializingBean 或 DisposableBean 接口
 *      3） 使用 JSR250 规范中的 @PostConstruct 注解，在 bean 创建完成 并且属性赋值完成 之后 进行 初始化
 *      4） 使用 BeanPostProcessor 后置处理器
 *          ---> BeanPostProcessor.postProcessBeforeInitialization 所有初始化方法调用之前执行
 *          ---> BeanPostProcessor.postProcessAfterInitialization 所有初始化方法调用之后执行
 *
 *      优先级： JSR注解方式 > 接口方式 > 自定义方法方式
 */
public class BeanTest4LifeCycle {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		System.out.println("容器创建完成");

		ctx.getBean("user");

		ctx.close();
	}


}

@Configuration
class LifeCycleConfig {

	//	@Scope("prototype")
	@Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	public User user() {
		return new User();
	}

	@Bean
	public BeanPostProcessor myBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}

}
