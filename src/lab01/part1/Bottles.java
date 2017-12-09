package lab01.part1;
import java.util.Scanner;

public class Bottles {

	public static void main(String[] args) {
		int numberOfBottles;
		Scanner keyboard = new Scanner(System.in);

		System.out.print("How many bottles?: ");
		numberOfBottles = keyboard.nextInt();
		bottleSong(numberOfBottles);
		keyboard.close();
	}

	public static void bottleSong(int n) {
		while (n > 0) {
			if (n == 1) {
				System.out.println(n + " bottle of beer on the wall");
				System.out.println(n + " bottle of beer");
				System.out.println("Take one down\nPass it around");
				System.out.println("");
				System.out.println("No more bottles of beer on the wall");
			} else {
				System.out.println(n + " bottles of beer on the wall");
				System.out.println(n + " bottles of beer");
				System.out.println("Take one down\nPass it around");
				System.out.println("");
			}
			n--;
		}
	}
}
