package com.leichu.spring.learn.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopAnnotationConfig {

	@Bean
	public MathCalculator mathCalculator(){
		return new MathCalculator();
	}

	@Bean
	public LoggerAspect loggerAspect(){
		return new LoggerAspect();
	}





}
