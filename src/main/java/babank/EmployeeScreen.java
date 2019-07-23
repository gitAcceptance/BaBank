package babank;

import java.util.HashMap;

public class EmployeeScreen {

	public class CustomerScreen {

		//Need to take in username to get info

			static void employeeMenu(Employee user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {
				
			int customerOption;
			do {	
			System.out.println("************************************");
			System.out.println("** Welcome to Community Bank B.A. **");
			System.out.println("************************************");

			System.out.println("\nHello " + user.name + "!");
			System.out.println("Please type either 1, 2, 3, 4, 5 to active the following: ");
			System.out.println("(1)Make new Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout");

			customerOption = UserInput.isInt();

			while(customerOption != 1 & customerOption != 2 & customerOption != 3 & customerOption != 4 & customerOption != 5) {
				System.out.println("\n**************************");
				System.out.println("Invalid menu option." );
				System.out.println("Please enter: (1)New Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout" );
				customerOption = UserInput.isInt();
			}

			switch(customerOption) {
			case 1:
				//Redirect to new Account screen
				break;
			case 2:
				//withdraw();
				break;
			case 3:
				//deposit();
				break;
			case 4:
				//transfer();
				break;
			case 5:
				Logout.save(accounts, users);
				System.out.println("\n\nThanks for visiting " + user.name + "!");
				System.out.println("\n***********************");
				System.out.println("** Logout Successful **");
				System.out.println("***********************");
				break;
			}

			}while(customerOption != 5);
			
		}//end customerMenu
	
}//end EmployeeScreen
