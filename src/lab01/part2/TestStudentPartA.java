package lab01.part2;
import java.util.Scanner;

public class TestStudentPartA {

	private final static int NUMBER_OF_STUDENTS = 20;
	
	public static void main(String[] args) {
		Student[] students = new Student[NUMBER_OF_STUDENTS];
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
			students[i] = new Student(firstName, lastName, mark);
		}
		for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
			students[i].print();
		}
		keyboard.close();
	}

}
