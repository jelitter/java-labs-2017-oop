package lab02.part3;

import java.util.ArrayList;
import java.util.Scanner;
import lab01.part2.Student;

public class TestStudentPartB {
	
	private final static int NUMBER_OF_STUDENTS = 2;
	
	public static void main(String[] args) {
		
		// As already used an Array for Part A, I'm going to implement it this time using an ArrayList
		ArrayList<Student> students = new ArrayList<Student>();
		String firstName;
		String lastName;
		int mark;
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
			System.out.println("Enter Student data.");
			System.out.print("First name: ");
			firstName = keyboard.next();
			System.out.print("Last name: ");
			lastName = keyboard.next();
			System.out.print("Mark: ");
			mark = keyboard.nextInt();
			students.add(new Student(firstName, lastName, mark));
		}
		
		for (Student s: students) {
			s.print();
		}
		
		keyboard.close();
	}
}
	
	

