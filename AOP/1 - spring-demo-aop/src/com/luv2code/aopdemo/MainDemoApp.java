package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO memberDAO =
				context.getBean("membershipDAO", MembershipDAO.class);
		Account acc = context.getBean("account",Account.class);
		
		// call the business method
		theAccountDAO.addAccount(acc, false);
		theAccountDAO.doWork();
		System.out.println();
		
		//second method
		memberDAO.addSillyStuff();
		memberDAO.sleep();
		
				
		// close the context
		context.close();
	}

}










