package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public void addAccount(Account acc, boolean c) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println("Doing my regular work.");
		
		return false;
	}

	public String getName() {
		System.out.println("Account - getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("Account - setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("Account - getCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("Account - setCode");
		this.serviceCode = serviceCode;
	}
	
	
}
