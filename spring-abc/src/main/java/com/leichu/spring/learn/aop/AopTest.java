package com.leichu.spring.learn.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP 原理： @EnableAspectJAutoProxy
 * <pre>
 *     1. @EnableAspectJAutoProxy 是什么？
 *          1). @Import(AspectJAutoProxyRegistrar.class) 给容器中注册 AspectJAutoProxyRegistrar 组件。
 *              利用 AspectJAutoProxyRegistrar 给容器中 自定义 注册 bean。
 *              ---> AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
 *                      ---> registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
 *                      ---> internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 * </pre>
 */
public class AopTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopAnnotationConfig.class);

//		ctx.getBean(MathCalculator.class).add(1, 2);
//		try {
//			ctx.getBean(MathCalculator.class).div(2, 0);
//		} catch (Exception e){
//			System.err.println(e);
//		}


	}

}
