package com.leichu.spring.learn.common.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

public class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	public User() {
		System.out.println("User ---------> 无参 构造器执行       实例化bean");
	}

	public User(String name, int age) {
		System.out.println("User ---------> 有参 构造器执行       实例化bean");
		this.name = name;
		this.age = age;
	}

	@PostConstruct
	public void afterConstruct() {
		this.name = "李四";
		this.age = 30;
		System.out.println("User ---------> afterConstruct 执行 ---------> @PostConstruct");
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("User ---------> 初始化bean -------> setName 执行");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("User ---------> 初始化bean -------> setAge 执行");
		this.age = age;
	}

	public void say() {
		System.out.println("User ---------> 自定义方法  say 执行");
	}

	public void myInit() {
		System.out.println("User ---------> 初始化bean -------> myInit 执行");
	}

	public void myDestroy() {
		System.out.println("User ---------> 销毁bean -------> myDestroy 执行");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("User ---------> Aware接口 ---------> BeanFactoryAware ---------> setBeanFactory 执行");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("User ---------> Aware接口 ---------> BeanNameAware ---------> setBeanName 执行");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("User ---------> 销毁bean -------> DisposableBean ---------> destroy 执行");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("User ---------> 初始化bean -------> InitializingBean ---------> afterPropertiesSet 执行");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("User ---------> Aware接口 ---------> ApplicationContextAware ---------> setApplicationContext 执行");
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}
