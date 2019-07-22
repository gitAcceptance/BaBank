package babank;

import java.util.Scanner;

public class BankApp {
	
	public static String[] login() {
		System.out.println("Please enter your user name.");
		Scanner in = new Scanner(System.in);
		String userName = in.nextLine();
		System.out.println("Please enter your password.");
		String userPass = in.nextLine();
		
		return new String[] {userName, userPass};
	}
	
	public static void customerLogin(String[] loginInfo) {
		
		
	}
	
	public static void employeeLogin(String[] loginInfo) {
			
		
	}
	
	public static void adminLogin(String[] loginInfo) {
		
	}

	public static void main(String[] args) {
		// Gonna need to load up our user data and account data first methinks.
		
		
		
		Scanner in = new Scanner(System.in);
		String userMode;
		
		do {
			System.out.println("Welcome to Community Bank B.A.");
			System.out.println("Please select your user type.");
			System.out.println();
			System.out.println("1. Customer");
			System.out.println("2. Bank Employee");
			System.out.println("3. Bank Administrator");
		
			userMode = in.nextLine();
			
			if (Integer.valueOf(userMode) == 1) {
				// Customer Mode
				customerLogin(login());
				break;
			} else if (Integer.valueOf(userMode) == 2) {
				// Employee Mode
				employeeLogin(login());
				break;
			} else if (Integer.valueOf(userMode) == 3) {
				// Admin Mode
				adminLogin(login());
				break;
			} else {
				System.out.println("Please enter a number 1-3.\n");
			}
		} while (true);
		
		
		in.close();
	}

}
