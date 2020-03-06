package com.leichu.spring.learn.common.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * 给属性赋值：
 * <pre>
 *     1. 基本类型
 *     2. 可以写 spEL 表达式：#{}
 *     3. 可以写 ${} ， 取出 配置文件中的值
 * </pre>
 */
public class User4PV {

	@Value("001")
	private long id;

	@Value("${user.name}")
	private String name;

	@Value("#{20-2}")
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "User4PV{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
