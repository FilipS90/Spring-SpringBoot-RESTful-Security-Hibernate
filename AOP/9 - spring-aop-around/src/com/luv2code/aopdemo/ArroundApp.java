package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class ArroundApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO AccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		AccountDAO.doWork();
		
		TrafficFortuneService traff = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		String x = traff.getFortune();
		
		System.out.println("My fortune is "+x);
		
				
		// close the context
		context.close();
	}

}










