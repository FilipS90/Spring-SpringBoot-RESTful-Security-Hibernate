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
		AccountDAO AccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO memberDAO =
				context.getBean("membershipDAO", MembershipDAO.class);
		Account acc = context.getBean("account",Account.class);
		acc.setLevel("Platinum");
		acc.setName("Madhu");
		
		// call the business method
		AccountDAO.addAccount(acc, false);
		AccountDAO.doWork();
		AccountDAO.getName();
		AccountDAO.setName("foobar");
		AccountDAO.setServiceCode("Huha");
		AccountDAO.getServiceCode();
		System.out.println();
		
		//second method
		memberDAO.addSillyStuff();
		memberDAO.sleep();
		
				
		// close the context
		context.close();
	}

}










