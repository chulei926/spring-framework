package com.leichu.spring.learn.ioc.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if ("user".equals(beanName)) {
			System.out.println("User ---------> BeanPostProcessor ---------> MyInstantiationAwareBeanPostProcessor ---------> postProcessBeforeInstantiation 执行");
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if ("user".equals(beanName)) {
			System.out.println("User ---------> BeanPostProcessor ---------> MyInstantiationAwareBeanPostProcessor ---------> postProcessAfterInstantiation 执行");
		}
		return false;
	}
}
