package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetSet()")
	public void beforeAddAcc(JoinPoint jp) {
		
		System.out.println("=====>>> Loggin operations.");
		
		MethodSignature sig = (MethodSignature) jp.getSignature();
		
		System.out.println("Method: "+sig);
		
		Object[] args = jp.getArgs();
		
		for(Object temp:args) {
			System.out.println(temp);
			
			if(temp instanceof Account) {
				
				Account X = (Account) temp;
				
				System.out.println("Account name: "+X.getName());
				System.out.println("Account level: "+X.getLevel());
			}
		}
	}	
	
}










