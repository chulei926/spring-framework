package com.leichu.spring.learn.bean;

import com.leichu.spring.learn.common.model.User4PV;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

public class BeanTest4PV {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyValueConfig.class);
		System.out.println("容器创建完成");

		ConfigurableEnvironment environment = ctx.getEnvironment();
		System.out.println("user.name ------> " + environment.getProperty("user.name"));
		System.out.println("user.age ------> " +environment.getProperty("user.age"));

		User4PV user4PV = (User4PV) ctx.getBean("user4PV");
		System.out.println(user4PV);
		ctx.close();
	}
}

@PropertySource(value = {"classpath:/config.properties"})
@Configuration
class PropertyValueConfig {

	@Bean
	public User4PV user4PV() {
		return new User4PV();
	}
}