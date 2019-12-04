package com.leichu.spring.learn.common.model;

import com.leichu.spring.learn.common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class User {

	@Autowired
	TestService testService;

	@PostConstruct
	public void afterConstruct(){
		System.out.println("------------- User 构造器执行之后，执行此方法 -------------" + testService);
	}

	public User(){
		System.out.println("------------- User 构造器 -------------" + testService);
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void say(){
		System.err.println(" ==================== hello user ==================== ");
	}
}
