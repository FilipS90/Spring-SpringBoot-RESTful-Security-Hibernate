package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
		String method = jp.getSignature().toShortString();
		System.out.println("\n====>>> Executing @After (finally) on method "+method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao."
					+ "AccountDAO.findAccounts(..))",
			throwing="exc")
	public void afterThrowingFindAccountsAdvice
						(JoinPoint jp, Throwable exc) {
		String method = jp.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterThrowing on method "+method);
		
		System.out.println("\n===>>> The exception is: "+exc);
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> result) {
		
		String method = jp.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterReturning on method "+method);
		
		System.out.println("\n==>>> result is "+result);
		
		convertAccountNamesToUpperCasePlusExtra(result);
		
		System.out.println("===>>> Results "+ result);
	}
	
	
	
	private void convertAccountNamesToUpperCasePlusExtra(List<Account> result) {
		for(Account s: result) {
			s.setName(s.getName().toUpperCase());
		}
		
	}



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










