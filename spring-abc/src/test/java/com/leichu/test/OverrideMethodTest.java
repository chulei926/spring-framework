package com.leichu.test;

public class OverrideMethodTest {
	public static void main(String[] args) {
		User user = new Student();
		user.setName("leichu");

		user.say();
	}


}

class User {
	private String name;
	public void say(){
		System.out.println("User-----------> say hello " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Student extends User{
	@Override
	public void say() {
		super.say();
	}

	public void say(String name, String content) {
		System.out.println("Student-----------> say hello " + name);
	}
}

