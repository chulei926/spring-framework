package com.leichu.spring.learn.mybatis.config;

import org.apache.ibatis.annotations.Select;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperInvocationHandler implements InvocationHandler {

	private Object object;

	public MyMapperInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Select selectAnnotation = method.getAnnotation(Select.class);
		String sql = selectAnnotation.value()[0];
		System.out.println(sql);


		System.out.println("dynamic proxy ---------> invoke -----> before");
		Object result = method.invoke(object, args);
		System.out.println("dynamic proxy ---------> result -----> " + result);
		System.out.println("dynamic proxy ---------> invoke -----> after");
		return result;
	}
}
