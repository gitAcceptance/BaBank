package com.revature.babank;

import java.util.Scanner;

public class BankApp {
	
	public String[] login() {
		System.out.println("Please enter your user name.");
		Scanner in = new Scanner(System.in);
		String userName = in.nextLine();
		System.out.println("Please enter your password.");
		String userPass = in.nextLine();
		
		return new String[] {userName, userPass};
	}
	
	public void customerLogin(String[] loginInfo) {
		
		
	}
	
	public void employeeLogin(String[] loginInfo) {
			
	}
	
	public void adminLogin(String[] loginInfo) {
		
	}

	public static void main(String[] args) {
		// Gonna need to load up our user data and account data first methinks.
		
		System.out.println("Welcome to Community Bank Ba");
		System.out.println("Please select your user type.");
		System.out.println();
		System.out.println("1. Customer");
		System.out.println("2. Bank Employee");
		System.out.println("3. Bank Administrator");
		
		Scanner in = new Scanner(System.in);
		String userMode = in.nextLine();
		
		do {
			if (Integer.valueOf(userMode) == 1) {
				// Customer Mode
				
			} else if (Integer.valueOf(userMode) == 2) {
				// Employee Mode
				
			} else if (Integer.valueOf(userMode) == 3) {
				// Admin Mode
				
			} else {
				System.out.println("Please enter a number 1-3.");
			}
		} while (true);
	}

}
