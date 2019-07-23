package babank;

import java.util.HashMap;

public class EmployeeScreen {

	static void employeeMenu(Employee user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		int employeeOption;
		do {	
			System.out.println("************************************");
			System.out.println("** Welcome to Community Bank B.A. **");  //<--Prints welcome message
			System.out.println("************************************");

			System.out.println("\nHello " + user.name + "!");
			System.out.println("Please type either 1, 2, 3, 4, or 5 to active the following: ");  //<--Asks Employee what they'd like to do
			System.out.println("(1)Customer Account Info  (2)Account Balances (3)Customer Info  (4)Approve/Deny Apps   (5)Logout");

			employeeOption = UserInput.isInt();  //<--Stores input into int

			//Checks that input was one of the listed options
			while(employeeOption != 1 & employeeOption != 2 & employeeOption != 3 & employeeOption != 4 & employeeOption != 5) {
				System.out.println("\n**************************");
				System.out.println("Invalid menu option." );
				System.out.println("Please enter: (1)Customer Account Info  (2)Account Balances (3)Customer Info  (4)Approve/Deny Apps   (5)Logout" );
				employeeOption = UserInput.isInt();
			}

			switch(employeeOption) {  //<--Executes the method chosen by the user
			case 1:
				UserActions.listAccounts(accounts, users);
				break;
			case 2:
				UserActions.accountBalance(accounts);
				break;
			case 3:
				UserActions.customerInfo(users);
				break;
			case 4:
				UserActions.accountApproval(accounts);
				break;
			case 5:
				Logout.save(accounts, users);  //<--Saves all user's data into a file
				System.out.println("\n\nThanks for your dedication " + user.name + "!");
				System.out.println("\n***********************");
				System.out.println("** Logout Successful **");  //<--Prints goodbye screen
				System.out.println("***********************");
				break;
			}

		}while(employeeOption != 5);

	}//end employeeMenu()

}//end EmployeeScreen
