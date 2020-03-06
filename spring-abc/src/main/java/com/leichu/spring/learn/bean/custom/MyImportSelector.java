package com.leichu.spring.learn.bean.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;

/**
 * 通过 ImportSelector 往 容器中注册组件.
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		for (MergedAnnotation<Annotation> annotation : importingClassMetadata.getAnnotations()) {
			System.out.println(">>>>>> " + annotation);
		}

		return new String[]{"com.leichu.spring.learn.common.model.color.Blue", "com.leichu.spring.learn.common.model.color.Red"};
	}
}
