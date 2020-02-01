package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyStuff() {
		
		System.out.println(getClass()+" "
				+ ": Doing silly stuff.");
		
		return true;
	}
	
	public boolean sleep() {
		
		System.out.println("Zzzzz...");
		
		return false;
	}
}
