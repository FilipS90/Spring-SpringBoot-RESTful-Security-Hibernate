package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO AccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accs = null;
		
		
		try {
			boolean tripWire = true;
			accs = AccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\nMain Program caught exception: "+exc);
		}
		
		
		
		System.out.println("\n\nProgram: AfterThrowingApp");
		System.out.println("----");
		
		System.out.println(accs);
		System.out.println("\n");
		
				
		// close the context
		context.close();
	}

}










