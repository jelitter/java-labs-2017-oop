package lab01.part3;

public class TestPerson {

	public static void main(String[] args) {
		Person p;
		
		String name = "John R.";
		String phone = "555-123-4321";
		int stars = 5;
		
		p = new Person(stars, phone, name);

		p.print();
		p.jump();
		p.jump(3);
		
		// Testing setters
		p.setName("Mary");
		p.setPhone("555-732-1144");
		p.setStars(4);
		p.print();
		
		// Testing getters
		System.out.println("Name: " + p.getName());
		System.out.println("Phone: " + p.getPhone());
		System.out.println("Stars: " + p.getStars());
	}

}
