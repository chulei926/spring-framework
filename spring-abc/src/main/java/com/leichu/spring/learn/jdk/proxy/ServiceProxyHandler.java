package com.leichu.spring.learn.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理。
 *
 * @author leichu 2020-01-10
 */
public class ServiceProxyHandler implements InvocationHandler {

	private Object object;

	public ServiceProxyHandler(Object object){
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("dynamic proxy ---------> invoke -----> before");
		Object result = method.invoke(object, args);
		System.out.println("dynamic proxy ---------> result -----> " + result);
		System.out.println("dynamic proxy ---------> invoke -----> after");
		return result;
	}
}
