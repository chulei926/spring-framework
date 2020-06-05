package com.leichu.spring.learn.common.model;

import com.leichu.spring.learn.jdk.proxy.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1350885741171127400L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
