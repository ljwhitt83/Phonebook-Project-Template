package home;

import java.util.Scanner;



public class Home {

	public static void main(String[] args) {

		// setup for new entry in cantacts class
		Contacts contact = new Contacts();
		Scanner sc = new Scanner(System.in);

		
		
		// display of options w/ option to exit in loop
		while (true) {
			System.out.println("Welcome to a basic phonebook app." 
		+ "\nWhat would you like to do?" 
					+ "\n1. Add Entry"
					+ "\n2. Show all entries"
					+ "\n3. Search phonebook" 
					+ "\n4. Update by phone number"
					+ "\n5. Delete record" 
					+ "\n6. Quit" 
					+ "\nEntry: ");
			// scanner for input
			int input = sc.nextInt();
			sc.nextLine();

			if (input == 6) {
				System.exit(0);
			}

			switch (input) {
			case 1:
				System.out.println("Please enter information followed by a comma");
				System.out.println("Example: John J Smith, 123 Smith Drive, Boston, MA, 04215, 123 421 4212");
				String ainput = sc.nextLine();
				try {
					contact.userInput(ainput);
				} catch (Exception e) {
					System.out.println("Wrong input format!");
				}
				break;
			case 2:
				System.out.println("Printing phone book");
				Contacts.printListing();
				break;
			case 3:
				System.out.println("Search phonebook options");
				System.out.println("1. Search by Phone number");
				System.out.println("2. Search by Full name");
				System.out.println("3. Search by First name");
				System.out.println("4. Search by Last name");
				System.out.println("5. Search by City");
				System.out.println("6. Search by State");
				int pInput = sc.nextInt();
				Contacts.serchingParam(pInput);
				break;
			case 4:
				System.out.println("Enter phone number to update record");
				String uInput = sc.nextLine();
				Contacts.updateRecord(uInput);
				break;
			case 5:
				System.out.println("Enter phone number");
				String dInput = sc.nextLine();
				Contacts.deleteRecord(dInput);
				break;
			default:
				System.out.println("Invalid input...");
				break;
			}

		}
	}
}