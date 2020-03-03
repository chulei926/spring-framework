package com.leichu.spring.learn.bean.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public MyBeanFactoryPostProcessor() {
		System.out.println("--- 注册了 MyBeanFactoryPostProcessor ");
	}

	/**
	 * 主要是用来修改 beanFactory 中持有的 BeanDefinition。
	 * 此处的 beanFactory 实际上就是 DefaultListableBeanFactory。
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		System.out.println(beanFactory instanceof DefaultListableBeanFactory); // true
//		for (String definitionName : beanFactory.getBeanDefinitionNames()) {
//			System.out.println(definitionName + " " + beanFactory.getBeanDefinition(definitionName).getPropertyValues());
//		}
		System.out.println("--- 执行了 MyBeanFactoryPostProcessor ");
	}
}
