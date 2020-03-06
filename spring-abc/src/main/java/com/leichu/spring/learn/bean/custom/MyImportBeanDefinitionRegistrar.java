package com.leichu.spring.learn.bean.custom;

import com.leichu.spring.learn.common.model.Student;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过 ImportBeanDefinitionRegistrar 往容器中注册 组件.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		if (!registry.containsBeanDefinition("student")){
			BeanDefinition definition =  new RootBeanDefinition(Student.class);
			registry.registerBeanDefinition("student", definition);
		}
	}
}
