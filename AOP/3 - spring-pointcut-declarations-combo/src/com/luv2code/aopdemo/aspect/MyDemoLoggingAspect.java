package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getters() {
		
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setters() {
		
	}
	
	@Pointcut("forDaoPackage() && !(setters() || getters())")
	private void forDaoPackageNoGetSet() {
		
	}

		
	@Before("forDaoPackageNoGetSet()")
	public void performApiAnalytics() {
		
		System.out.println("=====>>> Doing API analytics.");
	}
	
	
	
}










