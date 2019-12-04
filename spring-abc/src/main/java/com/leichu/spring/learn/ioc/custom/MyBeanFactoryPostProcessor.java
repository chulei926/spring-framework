package com.leichu.spring.learn.ioc.custom;

import com.leichu.spring.learn.common.model.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	public MyBeanFactoryPostProcessor(){
		System.out.println();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.err.println("--------------------执行了 MyBeanFactoryPostProcessors ");
		GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
//		genericBeanDefinition.setBeanClass(Animal.class);

	}
}
