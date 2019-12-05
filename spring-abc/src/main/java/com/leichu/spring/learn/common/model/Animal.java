package com.leichu.spring.learn.common.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

//@Component
public class Animal implements Lifecycle, InitializingBean, DisposableBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal() {
		System.out.println("------------- Animal init -------------");
	}

	public void say() {
		System.err.println(" ==================== hello animal ==================== ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Animal afterPropertiesSet。。。。。。");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Animal destroy。。。。。。");
	}

	@Override
	public void start() {
		System.out.println("Animal start。。。。。。");
	}

	@Override
	public void stop() {
		System.out.println("Animal stop。。。。。。");
	}

	@Override
	public boolean isRunning() {
		return true;
	}
}
