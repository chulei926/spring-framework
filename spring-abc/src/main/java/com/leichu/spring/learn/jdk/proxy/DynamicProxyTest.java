package com.leichu.spring.learn.jdk.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		ServiceProxyHandler handler = new ServiceProxyHandler(userService);
		UserService proxyService4UserService = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
		proxyService4UserService.say();

		System.out.println("--------------------------------------------------------------------");

		StudentService studentService = new StudentServiceImpl();
		ServiceProxyHandler studentServiceHandler = new ServiceProxyHandler(studentService);
		StudentService proxyService4StudentService = (StudentService) Proxy.newProxyInstance(studentService.getClass().getClassLoader(), studentService.getClass().getInterfaces(), studentServiceHandler);
		proxyService4StudentService.sayHello();

	}

}
