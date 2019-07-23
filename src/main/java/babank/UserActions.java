package babank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class UserActions {

	static int generateAccountKey(HashMap<Integer, Account> accounts) {

		Random rand = new Random();

		int newKey = 0;

		do {
			newKey = rand.nextInt(100000);
		} while (!accounts.containsKey(Integer.valueOf(newKey)));
		return newKey;
	}


	//------------------------------------Add Account-------------------------------------------

	static void addAccount(User user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		System.out.println("Please select your account type: ");
		System.out.println("(1)Checking  (2)Savings");
		int accountSelect = UserInput.isInt();  //<--Stores input as an int

		//Checks to make sure they are selecting an account listed to them
		while(accountSelect != 1 && accountSelect != 2) {
			System.out.println("\n**************************");
			System.out.println("Invalid account option. Please enter either 1 or 2.");
			accountSelect = UserInput.isInt();
		}

		AccountType type;

		if(accountSelect == 1) {
			type = AccountType.CHECKING;
		}else {
			type = AccountType.SAVINGS;
		}

		int newKey = generateAccountKey(accounts);
		Account a = new Account(newKey, LocalDateTime.now(), type);
		a.addOwner(user.getUserName());

		//For joint accounts
		System.out.println("Would you like to make this a joint account?");
		System.out.println("(1)Yes  (2)No");
		int yesNo = UserInput.isInt();  //<--Stores input as an int

		//Checks to make sure they are selecting an account listed to them
		while(yesNo != 1 && yesNo != 2) {
			System.out.println("\n**************************");
			System.out.println("Invalid account option. Please enter either 1 or 2.");
			yesNo = UserInput.isInt();
		}
		if (yesNo == 1) {
			System.out.println("Please enter the other person's name: ");
			String name = UserInput.isString();		
			a.addOwner(name);
		}

		accounts.put(newKey, a);

	}//end addAccount()


	//------------------------------------View Account Info-------------------------------------------
	static void listAccounts(HashMap<Integer, Account> accounts, HashMap<String, User> users) {
		int counter = 0;
		for (Account acc : accounts.values()) {
			System.out.println("(" + counter + ") " + acc);
			counter++;
		}
	}//end accountInfo()


	//------------------------------------View Account Balance-------------------------------------------
	static void accountBalance(HashMap<Integer, Account> accounts) {
		for (Account a : accounts.values()) {
			a.toString();
		}
	}//end accountBalance()


	//------------------------------------View Customer Info-------------------------------------------
	static void customerInfo(HashMap<String, User> users) {
		for (User u : users.values()) {
			if (u.getType() == UserType.CUSTOMER) {
				System.out.println(u);
			}
		}
	}//end customerInfo()


	//------------------------------------Account Approval-------------------------------------------
	static void accountApproval(HashMap<Integer, Account> accounts) {
		//Creates an ArrayList to store all Accounts
		ArrayList<Account> accountList = new ArrayList<Account>();
		int counter = 0;
		for (Account a : accounts.values()) {
			if(a.isPendingApproval()) {
				accountList.add(accounts.get(a));
				System.out.println("(" + counter + ") " + a);
				counter++;
			}
		}

		//For joint accounts
		System.out.println("\nPlease specify which account you'd like to approve.");  //<--Asks user to specify account they'd like to withdraw from
		System.out.println("Enter a number from 0 - " + accountList.size());
		int accountNum = UserInput.isInt();  //<--Stores input as an int

		//Checks to make sure they are selecting an account listed to them
		while(accountNum < 0 || accountNum > accountList.size()) {
			System.out.println("\n**************************");
			System.out.println("Invalid account option. Please enter a number from 0 - " + accountList.size());
			accountNum = UserInput.isInt();
		}

		accountList.get(accountNum).approve();

	}//end accountApproval()


	//------------------------------------Admin Approval-------------------------------------------
	static void adminApproval(HashMap<String, User> users) {
		for (User u : users.values()) {
			if (u.type == UserType.EMPLOYEE) {
				Employee e = (Employee) u;
				if(e.isPendingApproval) {
					System.out.println(e);
				}
			}
		}
	}//end adminApproval()


	//------------------------------------Withdraw-------------------------------------------
	static void withdraw(Customer user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		System.out.println("\n** Withdraw **");  //<--Displays action screen
		System.out.println("Here are your accounts: " );  //<--Loads in all accounts (ID + Type + Balance + Name)

		//Creates an ArrayList to store all Accounts
		ArrayList<Account> accountList = new ArrayList<Account>();

		int counter = 0;  //<--Uses a counter to help with user input

		//Loads Accounts into ArrayList and prints out for user
		for(Integer i : user.accounts) { 
			if (accounts.get(i).isPendingApproval() || accounts.get(i).isOpen == false) {  //<--If account is not approved, it will not print
				continue;
			}
			accountList.add(accounts.get(i));
			System.out.println("(" + counter + ") " + accounts.get(i).toString());
			counter++;
		}

		if(accountList.size() != 0) {
			System.out.println("\nPlease specify which account you'd like to withdraw from.");  //<--Asks user to specify account they'd like to withdraw from
			System.out.println("Enter a number from 0 - " + accountList.size());
			int accountSelect = UserInput.isInt();  //<--Stores input as an int

			//Checks to make sure they are selecting an account listed to them
			while(accountSelect < 0 || accountSelect > accountList.size()) {
				System.out.println("\n**************************");
				System.out.println("Invalid account option. Please enter a number from 0 - " + accountList.size());
				accountSelect = UserInput.isInt();
			}

			//Stores balance of the selected account into variable
			double balance = accounts.get(accountSelect).getBalance();

			//Can only withdraw if they have funds
			if(balance > 0) {
				System.out.println("\nThis account currently has $" + balance);  //<--Prints current balance to the user
				System.out.println("Please specify the amount you'd like to withdraw:");  
				double amount = Math.round(UserInput.isDouble() * 100) / 100d;  //<--Stores input as a double


				//Checks to make sure they cannot overdraw account or input an invalid amount
				while(amount < 0 || amount > balance) {
					System.out.println("\n**************************");
					System.out.println("Invalid amount. Please specify the amount you'd like to withdraw:");
					amount = Math.round(UserInput.isDouble() * 100) / 100d;
				}

				//Withdraws from account
				balance -= amount;

				System.out.println("\nYour withdrawl of $" + amount + " was successful.");
				System.out.println("Your new balance is: $" + balance); //<--Prints updated balance
			}

			else {
				System.out.println("You currently have no funds to withdraw"); //<--Prints that user has insufficient funds
			}
		}else {
			System.out.println("You currently have no active accounts"); //<--Prints that user has no accounts
		}


	}//end withdraw()


	//------------------------------------Deposit------------------------------------------
	static void deposit(Customer user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		System.out.println("\n** Deposit **");  //<--Displays action screen
		System.out.println("Here are your accounts: " );  //<--Loads in all accounts (ID + Type + Balance + Name)

		//Creates an ArrayList to store all Accounts
		ArrayList<Account> accountList = new ArrayList<Account>();

		int counter = 0;  //<--Uses a counter to help with user input

		//Loads Accounts into ArrayList and prints out for user
		for(Integer i : user.accounts) { 
			if (accounts.get(i).isPendingApproval() || accounts.get(i).isOpen == false) {  //<--If account is not approved, it will not print
				continue;
			}
			accountList.add(accounts.get(i));
			System.out.println("(" + counter + ") " + accounts.get(i).toString());
			counter++;
		}
		if(accountList.size() != 0) {
			System.out.println("\nPlease specify which account you'd like to deposit into.");  //<--Asks user to specify account
			System.out.println("Enter a number from 0 - " + accountList.size()); 
			int accountSelect = UserInput.isInt();  //Stores input as an int

			//Checks to make sure they are selecting an account listed to them
			while(accountSelect < 0 || accountSelect > accountList.size()) {
				System.out.println("\n**************************");
				System.out.println("Invalid account option. Please enter a number from 0 - " + accountList.size());
				accountSelect = UserInput.isInt();
			}

			//Stores balance of the selected account into variable
			double balance = accounts.get(accountSelect).getBalance();

			System.out.println("\nThis account currently has $" + balance); //<--Get balance of account
			System.out.println("Please specify the amount you'd like to deposit:");
			double amount = Math.round(UserInput.isDouble() * 100) / 100d;  //<--Stores input as a double

			//Deposits into account
			balance += amount;

			System.out.println("\nYour deposit of $" + amount + " was successful."); 
			System.out.println("Your new balance is: $" + balance); //<--Print updated balance
		}
		else {
			System.out.println("You currently have no active accounts"); //<--Prints that user has no accounts
		}
	}//end deposit()


	//------------------------------------Transfer------------------------------------------
	static void transfer(Customer user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		System.out.println("\n** Transfer **");  //<--Displays action screen
		System.out.println("Here are your accounts: " );  //<--Loads in all accounts (ID + Type + Balance + Name)

		//Creates an ArrayList to store all Accounts
		ArrayList<Account> accountList = new ArrayList<Account>();

		int counter = 0;  //<--Uses a counter to help with user input

		//Loads Accounts into ArrayList and prints out for user
		for(Integer i : user.accounts) { 
			if (accounts.get(i).isPendingApproval() || accounts.get(i).isOpen == false) {  //<--If account is not approved, it will not print
				continue;
			}
			accountList.add(accounts.get(i));
			System.out.println("(" + counter + ") " + accounts.get(i).toString());
			counter++;
		}

		if(accountList.size() != 0) {
			System.out.println("\nPlease specify which account you'd like to transfer from.");  //<--Asks user to specify starting account
			System.out.println("Enter a number from 0 - " + accountList.size()); 
			int accountSelect = UserInput.isInt();  //<--Stores input as an int

			//Checks to make sure they are selecting an account listed to them
			while(accountSelect < 0 || accountSelect > accountList.size()) {
				System.out.println("\n**************************");
				System.out.println("Invalid account option. Please enter a number from 0 - " + accountList.size());
				accountSelect = UserInput.isInt();
			}


			System.out.println("\nPlease specify which account you'd like to transfer to.");  //<--Asks user to specify destination account
			System.out.println("Enter a number " + "(numbers of accounts)"); 
			int accountSelect2 = UserInput.isInt();  //<--Stores input as an int


			//Checks to make sure they are selecting an account listed to them
			while(accountSelect2 < 0 || accountSelect2 > accountList.size()) {
				System.out.println("\n**************************");
				System.out.println("Invalid account option. Please enter a number from 0 - " + accountList.size());
				accountSelect2 = UserInput.isInt();
			}

			//Stores balance of the selected accounts into variable
			double balance = accounts.get(accountSelect).getBalance();
			double balance2 = accounts.get(accountSelect2).getBalance();

			//Can only withdraw if they have funds
			if(balance > 0) {
				System.out.println("\nYour account currently has $" + balance); //<--Get balance of account
				System.out.println("Please specify the amount you'd like to transfer:");
				double amount = Math.round(UserInput.isDouble() * 100) / 100d;  //<--Stores input as a double

				//Checks to make sure they cannot overdraw account or input an invalid amount
				while(amount < 0 || amount > balance) {
					System.out.println("\n**************************");
					System.out.println("Invalid amount. Please specify the amount you'd like to transfer:");
					amount = Math.round(UserInput.isDouble() * 100) / 100d;
				}

				//Transfers between accounts
				balance -= amount;  
				balance2 += amount;  

				System.out.println("\nYour transfer of $" + amount + " was successful."); 
				System.out.println("Your new balance is: $" + balance); //<--Print updated balance of accountSelect
			}
			else {
				System.out.println("You currently have no funds to transfer"); //<--Prints that user has insufficient funds
			}
		}
		else {
			System.out.println("You currently have no active accounts"); //<--Prints that user has no accounts
		}
	}//end transfer()

}//end UserActions class
