package com.leichu.spring.learn.jdk;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		MyFunIntTest test = new MyFunIntTest();
		test.setName("leichu");

		test.say("happy", (name -> {
			String con = "happy life";
			System.out.println(name + " " + con);
		}));
	}


	static class MyFunIntTest {

		private String name;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void say(String content, MyFunctionalInterface<String> myFunctionalInterface) {
			System.out.println("hello " + this.name + " " + content);
			myFunctionalInterface.sayHello(name);
		}

	}


}

