package com.leichu.spring.learn.jdk.proxy;

/**
 * 静态代理。<br />
 * 由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
 *
 * @author leichu 2020-01-10
 */
public class UserServiceProxy implements UserService {

	private UserService userService = new UserServiceImpl();

	@Override
	public String say() {
		System.out.println("static proxy ---------> invoke -----> before");
		userService.say();
		System.out.println("static proxy ---------> invoke -----> after");
		return "static proxy invoke success";
	}
}
