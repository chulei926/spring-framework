package com.leichu.spring.learn.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP 原理： @EnableAspectJAutoProxy
 * <pre>
 *     1. @EnableAspectJAutoProxy 是什么？
 *          1). @Import(AspectJAutoProxyRegistrar.class) 给容器中注册 AspectJAutoProxyRegistrar 组件。
 *              利用 AspectJAutoProxyRegistrar 给容器中 自定义 注册 bean。
 *              在容器中创建一个 AnnotationAwareAspectJAutoProxyCreator，名称为 internalAutoProxyCreator 的自动代理创建器。
 *              ---> AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
 *                      ---> registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
 *                      ---> internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *      2. AnnotationAwareAspectJAutoProxyCreator 组件有什么作用？
 *          1）. AnnotationAwareAspectJAutoProxyCreator 组件的继承关系：
 *                  ---> extends AspectJAwareAdvisorAutoProxyCreator
 *                      ---> extends AbstractAdvisorAutoProxyCreator
 *                          ---> extends AbstractAutoProxyCreator
 *                              ---> implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware（重要！！！）
 *          2）. setBeanFactory。 调用 AbstractAdvisorAutoProxyCreator 的 setBeanFactory() 方法，其中又调用了父类 AbstractAutoProxyCreator 的 setBeanFactory() 方法。
 *                  ---> AbstractAdvisorAutoProxyCreator.setBeanFactory()
 *                  ---> AbstractAutoProxyCreator.setBeanFactory()
 *          3）. AbstractAutoProxyCreator.postProcessBeforeInstantiation()
 *          4）. 实例化 （MathCalculator contractor ......）
 *          5）. AbstractAutoProxyCreator.postProcessAfterInitialization()
 *          6）. DefaultAopProxyFactory.createAopProxy()
 * </pre>
 */
public class AopTest {

	/**
	 * >>>>>> AOP postProcessBeforeInstantiation （AbstractAutoProxyCreator.postProcessBeforeInstantiation） >>> mathCalculator
	 * ---> MathCalculator contractor ......
	 * >>>>>> AOP postProcessAfterInitialization （AbstractAutoProxyCreator.postProcessAfterInitialization） >>> mathCalculator
	 * >>>>>> AOP createAopProxy （DefaultAopProxyFactory.createAopProxy） com.leichu.spring.learn.aop.MathCalculator
	 *
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopAnnotationConfig.class);

		MathCalculator calculator = ctx.getBean(MathCalculator.class);
		calculator.add(1, 2);
//		try {
//			ctx.getBean(MathCalculator.class).div(2, 0);
//		} catch (Exception e){
//			System.err.println(e);
//		}


	}

}
