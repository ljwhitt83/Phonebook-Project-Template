package home;

import java.util.Arrays;
import java.util.Scanner;


public class Contacts {

	static Person[] tracking = new Person[0];

	static Scanner sc = new Scanner(System.in);

	public void  userInput(String input) {
		// getting input from user and splitting the string based off the commas
		String[] splitPerson = input.split(",");

		// splitting full name into first, middle, last
		String myName = splitPerson[0];
		String[] splitName = myName.split(" ");
		// setting first name from initial split of string
		String fName = splitName[0];
		// splitting the middlename
		String mName = "";
		for (int i = 1; i < splitName.length - 1; i++) {
			mName += splitName[i] + " ";
		}

		// setting last name
		String lName = splitName[splitName.length - 1];

		// getting entries for street, city, state, zip, phone
		String street = splitPerson[1];
		String city = splitPerson[2];
		String state = splitPerson[3];
		String zip = splitPerson[4];
		String phone = splitPerson[5];
		
		//creating new contact object
		Person newEntry = new Person(fName, mName, lName, new Address(street, city, state, zip), phone);
		
		////adjusting array size to make room for new entry
		Person[] temp = new Person[tracking.length + 1];
		for (int i = 0; i < tracking.length; i++) {
			temp[i] = tracking[i];
		}
		temp[temp.length - 1] = newEntry;
		tracking = temp;		
		System.out.println("Input was successful");
		
		//sort array after new inputs are received		
	}
	
	public static void printListing() {
		Arrays.sort(tracking);
		for(int i = 0; i < tracking.length; i++) {
			System.out.println(tracking[i]);
		}
	}
	
	public static void serchingParam(int pInput) {
		switch (pInput) {
        case 1:
            System.out.println("Enter a number");
            String aInput = sc.nextLine();
            searchByPhone(aInput);
            break;
        case 2:
            System.out.println("Enter the full name");
            String bInput = sc.nextLine();
            searchByFullName(bInput);
            break;
        case 3:
            System.out.println("Enter a first name");
            String cInput = sc.nextLine();
            searchbyFirst(cInput);
            break;
        case 4:
            System.out.println("Enter a last name");
            String dInput = sc.nextLine();
            searchbyLast(dInput);
            break;
        case 5:
            System.out.println("Enter a city");
            String eInput = sc.nextLine();
            searchbyCity(eInput);
            break;
        case 6:
            System.out.println("Enter a state");
            String fInput = sc.nextLine();
            searchbyState(fInput);
            break;
		}
	}
	public static void searchByPhone(String phone) {
        Person[] samePhone = new Person[10];
        int count = 0;

        for (int i = 0; i < tracking.length; i++) {
            if (phone.equals(tracking[i].getPhone())) {
                samePhone[count] = tracking[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found");
        for (int i = 0; i < samePhone.length; i++) {
            if(samePhone[i] != null) {
                System.out.println(samePhone[i]);
            }
        }
    }

    public static void searchByFullName(String fullname) {
        Person[] sameFullName = new Person[10];
        int count = 0;

        for (int i = 0; i < tracking.length; i++) {
            if (fullname.equals(tracking[i].getfuName()))
            {
                sameFullName[count] = tracking[i];
            }

            count++;

        }

        System.out.println("Here are the matches we found");
        for (int i = 0; i < sameFullName.length; i++) {
            if(sameFullName[i] != null) {
                System.out.println(sameFullName[i]);
            }
            }
    }

    public static void searchbyFirst(String first) {
        Person[] sameFirst = new Person[10];
        int count = 0;

        for (int i = 0; i < tracking.length; i++) {
            if (first.equals(tracking[i].getfName())) {
                sameFirst[count] = tracking[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found`");
        for (int i = 0; i < sameFirst.length; i++) {
            if(sameFirst[i] != null) {
                System.out.println(sameFirst[i]);
            }
        }
    }

    public static void searchbyLast(String last) {
        Person[] sameLast = new Person[10];
        int count = 0;

        for (int i = 0; i < tracking.length; i++) {
            if (last.equals(tracking[i].getlName())) {
                sameLast[count] = tracking[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found`");
        for (int i = 0; i < sameLast.length; i++) {
            if(sameLast[i] != null) {
                System.out.println(sameLast[i]);
            }
        }
    }

    public static void searchbyCity(String city) {
        Person[] sameCity = new Person[10];
        int count = 0;

        for (int i = 0; i < tracking.length; i++) {
            if (tracking[i].getAddress().isCity(city)) {
                sameCity[count] = tracking[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found");
        for (int i = 0; i < sameCity.length; i++) {
            if(sameCity[i] != null) {
                System.out.println(sameCity[i]);
            }
        }
    }

    public static void searchbyState(String state) {
        Person[] sameState = new Person[10];
        int count = 0;

        for (int i = 0; i < tracking.length; i++) {
            if (tracking[i].getAddress().isState(state)) {
                sameState[count] = tracking[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found`");
        for (int i = 0; i < sameState.length; i++) {
            if(sameState[i] != null) {
                System.out.println(sameState[i]);
            }
        }
    }

    //I could either do each individual one...or update the whole object...
    public static void updateRecord(String phone) {

        for (int i = 0; i < tracking.length; i++) {
            if (phone.equals(tracking[i].getPhone())) {
                System.out.println("We found: ");
                System.out.println(tracking[i]);
                System.out.println("What would you like to change? ");
                System.out.println("1. First Name");
                System.out.println("2. Middle Name");
                System.out.println("3. Last name");
                System.out.println("4. Address");
                System.out.println("5. Phone number");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String firstName = sc.nextLine();
                        tracking[i].setfName(firstName);
                        System.out.println("Updated");
                        break;
                    case 2:
                        System.out.println("Enter new Middle Name");
                        String middleName = sc.nextLine();
                        tracking[i].setmName(middleName);
                        System.out.println("Updated");
                        break;
                    case 3:
                        System.out.println("Enter new Last Name");
                        String lastName = sc.nextLine();
                        tracking[i].setlName(lastName);
                        System.out.println("Updated");
                        break;
                    case 4:
                        System.out.println("Please seperate by commas. ie: 123 Smith Road, Boston, MA, 02709 ");
                        String address = sc.nextLine();
                        String[] splitAddress = address.split(",");
                        String street = splitAddress[0];
                        String city = splitAddress[1];
                        String state = splitAddress[2];
                        String zip = splitAddress[3];
                        tracking[i].getAddress().setStreet(street);
                        tracking[i].getAddress().setCity(city);
                        tracking[i].getAddress().setState(state);
                        tracking[i].getAddress().setZip(zip);
                        System.out.println("Updated!");
                        break;
                    case 5:
                        System.out.println("Enter new phone number");
                        String phoneNumber = sc.nextLine();
                        tracking[i].setPhone(phoneNumber);
                        System.out.println("Updated");
                        break;
                }


            }


        }

    }

    public static void deleteRecord(String phone) {
        boolean delete;
        for (int i = 0; i < tracking.length; i++) {
            if (phone.equals(tracking[i].getPhone())) {
                System.out.println("We found: ");
                System.out.println(tracking[i]);
                System.out.println("Would you like to delete this record? (Yes/No) ");
                String input = sc.nextLine();
                input.toLowerCase();
                if(input.equals("yes"))
                {
                    tracking[i] = null;
                }
            }

        }
        resizeArray();
    }

    public static void resizeArray(){
        int size = 0;
        for(int i = 0; i<tracking.length; i++)
        {
            if(tracking[i] != null)
            {
                size++;
            }

        }
        Person [] tempA = new Person [size];

        for(int i = 0; i<tracking.length; i++){
            if(tracking[i] != null){
                tempA[i] = tracking[i];
            }
        }
        tracking = tempA;
    }



}
