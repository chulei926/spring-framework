package com.leichu.spring.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * AOP:
 * 前置通知：在目标方法运行开始之前运行
 * 后置通知：在目标方法运行结束之后运行(不论正常返回还是异常返回)
 * 返回通知：在目标方法正常返回之后运行
 * 异常通知：在目标方法出现异常之后运行
 * 环绕通知：动态代理，手动推进目标方法执行（JoinPoint.procced()）
 */

@Aspect
public class LoggerAspect {

	@Pointcut("execution(public int com.leichu.spring.learn.aop.MathCalculator.*(..))")
	public void pointCut() {

	}

	// 该类内部调用 pointCut()，直接写方法名即可。
	// 如果是外部类要引入 pointCut()，需要写方法全类名
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " 方法开始，参数：" + Arrays.asList(joinPoint.getArgs()));
	}

	// 外部引入 样例
	@After("com.leichu.spring.learn.aop.LoggerAspect.pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " 方法结束，参数：" + Arrays.asList(joinPoint.getArgs()));
	}

	// joinPoint 一定要放在参数列表的第一位
	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + " 方法返回，参数：" + Arrays.asList(joinPoint.getArgs()) + "返回值：" + result);
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println(joinPoint.getSignature().getName() + " 方法异常，异常信息如下：");
		exception.printStackTrace();
	}

	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around start >>>>>>");
		Object obj = joinPoint.proceed();
		System.out.println(obj);
		System.out.println("Around end >>>>>>");
		return obj;
	}

}
