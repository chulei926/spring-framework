package com.leichu.spring.learn.ioc.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor(){
		System.out.println("+++++++++++++++ MyBeanPostProcessor +++++++++++++++");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("user".equals(beanName)){
			System.out.println("==============前处理=============== beanName: " + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("user".equals(beanName)){
			System.out.println("==============后处理=============== beanName: " + beanName);
		}
		return bean;
	}
}
