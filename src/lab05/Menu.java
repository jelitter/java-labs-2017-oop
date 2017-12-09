package lab05;

import java.util.Scanner;

public class Menu {

	public static final int MENU_EXIT                      = 0;
	public static final int MENU_ADD_LECTURER              = 1;
	public static final int MENU_FIND_LECTURER_BY_ID       = 2;
	public static final int MENU_ADD_BOOK_TO_LECTURER      = 3;
	public static final int MENU_REMOVE_BOOK_FROM_LECTURER = 4;
	public static final int MENU_SEARCH_BOOK_BY_ISBN       = 5;
	public static final int MENU_YEARLY_BOOK_PAYMENT       = 6;
	public static final int MENU_PRINT_ALL_BOOKS           = 7;

	private static final String[] menuOptions = new String[] {
	        "Exit",
	        "Add Lecturer",
	        "Find Lecturer by ID",
	        "Add book to Lecturer",
	        "Remove book from Lecturer",
	        "Search book by ISBN",
	        "Calculate yearly book payment",
	        "Show all books"
    };
	
	private Scanner kb;
	
	public Menu() {
		this.kb = new Scanner(System.in);
	}
	
	public void show() {
		
		int i = 0;
		
		System.out.println("\n\n");
		System.out.println("===================================");
		System.out.println("  OPTIONS - Main Menu");
		System.out.println("===================================");
		for (String s: Menu.menuOptions) {
		    System.out.println("  " + i + ". " + s);
		    i++;
		}
		System.out.println("===================================\n");
	}
	
	public int readOption() {

		int opt = -1;
		Boolean validOption = false;
		
		while (!validOption) {
			System.out.print("  Enter option: ");
			try {
				opt = Integer.parseInt(kb.nextLine());
				if (opt < Menu.menuOptions.length && opt >= 0) {
					validOption = true;
				} else {
					System.out.println("  Invalid option. Please pick a valid option [0 - " + (Menu.menuOptions.length -1) + "]");
				}
			} catch (Exception e) {
				System.out.println("  Invalid option. Please pick a valid option [0 - " + (Menu.menuOptions.length -1) + "]");
			} 
		}
		return opt;
	}

	public String readString(String stringName) {
		System.out.print("  Enter " + stringName + ": ");
		String result = kb.nextLine();
		return result;
	}

	public int readInt(String intName) {
		int myInt = -1;
		Boolean validOption = false;
		
		while (!validOption) {
			System.out.print("  Enter " + intName + ": ");
			try {
				myInt = Integer.parseInt(kb.nextLine());
				validOption = true;
			} catch (Exception e) {
				System.out.println("Invalid " + intName + ". Please enter a integer number.");
			} 
		}
		
		return myInt;
	}

	public double readDouble(String doubleName) {
		double myDouble = -1;
		Boolean validOption = false;
		
		while (!validOption) {
			System.out.print("  Enter " + doubleName + ": ");
			try {
				myDouble = Double.parseDouble(kb.nextLine());
				validOption = true;
			} catch (Exception e) {
				System.out.println("Invalid " + doubleName + ". Please enter a double number.");
			} 
		}
		return myDouble;
	}

	public static void printTitle(int option) {
		System.out.println("\n  ===============================");
		System.out.println("    Selected: " + Menu.menuOptions[option]);
		System.out.println("  ===============================\n");
	}
}





