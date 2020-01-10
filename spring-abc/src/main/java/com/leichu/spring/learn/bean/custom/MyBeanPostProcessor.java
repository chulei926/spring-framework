package com.leichu.spring.learn.bean.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		System.out.println("+++++++++++++++ MyBeanPostProcessor 构造器执行，实例化完成 +++++++++++++++");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("user".equals(beanName)) {
			System.out.println("User ---------> BeanPostProcessor ---------> postProcessBeforeInitialization 执行   ---------> 所有初始化方法调用之前执行");
		}

		if ("userService".equals(beanName)) {
			System.out.println("UserServiceImpl ---------> BeanPostProcessor ---------> postProcessBeforeInitialization 执行   ---------> 所有初始化方法调用之前执行");
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("user".equals(beanName)) {
			System.out.println("User ---------> BeanPostProcessor ---------> postProcessAfterInitialization 执行  ---------> 所有初始化方法调用之后执行");
		}

		if ("userService".equals(beanName)) {
			System.out.println("UserServiceImpl ---------> BeanPostProcessor ---------> postProcessAfterInitialization 执行  ---------> 所有初始化方法调用之后执行");
		}
		return bean;
	}
}
