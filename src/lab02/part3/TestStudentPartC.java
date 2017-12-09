package lab02.part3;
import java.util.ArrayList;
import java.util.Scanner;

import lab01.part2.Student;

public class TestStudentPartC {

	private static final int OPT_ADD_STUDENT = 1;
	private static final int OPT_REMOVE_STUDENT = 2;
	private static final int OPT_LIST_STUDENT = 3;
	private static final int OPT_EXIT = 4;
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<Student>();
		String firstName;
		String lastName;
		int mark = 0;
		int option = 0;

		do {
			option = studentMenu();

			switch (option) {
			case OPT_ADD_STUDENT:
				System.out.println("============================");
				System.out.println("Enter Student data.");
				System.out.print("First name: ");
				firstName = keyboard.next();
				System.out.print("Last name: ");
				lastName = keyboard.next();
				System.out.print("Mark: ");
				mark = keyboard.nextInt();
				students.add(new Student(firstName, lastName, mark));
				break;

			case (OPT_REMOVE_STUDENT):
				System.out.println("============================");
				System.out.println("Remove Student:");
				System.out.print("First name: ");
				firstName = keyboard.next();
				System.out.print("Last name: ");
				lastName = keyboard.next();
				
				boolean found = false;
				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).getFirstName().equals(firstName) && 
						students.get(i).getLastName().equals(lastName)) {
						found = true;
						students.remove(i);
						System.out.println("Student \"" + firstName + " " + lastName + "\" removed from list.");
						break;
					}
				}
				if (!found)
					System.out.println("Couldn't remove student \"" + firstName + " " + lastName + "\" from list (not found).");
				
				break;

			case (OPT_LIST_STUDENT):
				System.out.println("============================");
				System.out.println("Student List:");
				for (Student s: students) {
					s.print();
				}
				break;
				
			case (OPT_EXIT):
				System.out.println("Exiting program.");
				break;

			default:
				System.out.println("Please a valid option.");
				break;

			} 

		} while (option != OPT_EXIT);
	}

	public static int studentMenu() {

		System.out.println("\n\n\n\n\n");
		System.out.println("============================");
		System.out.println("    STUDENT MENU");
		System.out.println("============================");
		System.out.println("    " + OPT_ADD_STUDENT + ". ADD STUDENT");
		System.out.println("    " + OPT_REMOVE_STUDENT + ". REMOVE STUDENT");
		System.out.println("    " + OPT_LIST_STUDENT + ". LIST STUDENTS");
		System.out.println("    " + OPT_EXIT + ". EXIT");
		System.out.println("============================");
		System.out.print("    Enter Option: ");
		return keyboard.nextInt();
	}

	
	//
	// What are the advantages of using an ArrayList over an array?
	//
	// An Array by definition has a fixed size, and can't shrink or grow as needed.
	// On the other hand an ArrayList can change its size as needed to hold 
	// an (in principle) unknown amount of items.
	//
	
	
	

}