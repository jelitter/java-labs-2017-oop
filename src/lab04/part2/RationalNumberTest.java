package lab04.part2;

public class RationalNumberTest {
	public static void main(String[] args) {

		RationalNumber a, b, c;

		a = new RationalNumber(1,3);
		b = new RationalNumber(1,5);

		System.out.println("-------------");
		System.out.println(" a: " + a);
		System.out.println(" b: " + b);
		System.out.println("-------------");
		System.out.println(" a + b: " + a.add(b));
		System.out.println(" a - b: " + a.sub(b));
		System.out.println(" a * b: " + a.mult(b));
		System.out.println(" a / b: " + a.div(b));
		System.out.println("-------------");

		// Chaining operations
		c = new RationalNumber(1,7);

		System.out.println(" ( a + b ) / c: " + a.add(b).div(c) );
		System.out.println("   a + b   / c: " + a.add(b.div(c)) );
		System.out.println("-------------");

		// Bonus: equals
		System.out.println(" a = a: " + a.equals(a));
		System.out.println(" a = b: " + a.equals(b));
		System.out.println(" a + b = b + a: " + a.add(b).equals(b.add(a)) );
	}
}
