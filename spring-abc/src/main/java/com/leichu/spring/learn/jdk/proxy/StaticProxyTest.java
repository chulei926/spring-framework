package com.leichu.spring.learn.jdk.proxy;

public class StaticProxyTest {

	public static void main(String[] args) {
		UserService proxy = new UserServiceProxy();
		System.out.println(proxy.say());
	}

}
