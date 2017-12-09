package lab03.part2;

public class PersonCatTest {
	
	static Person person;
	static Cat[] cats;

	public static void main(String[] args) {
		
		person = new Person("Isaac", 39, "Cork");
		cats = new Cat[20];
		
		
		person.print();
		System.out.println("Adopting 20 pets...");

		// Adding 20 cats with random ages between 0 and 10 years.
		for (int i = 0; i < cats.length; i++) {
			cats[i] = new Cat("Cat-name-" + i, (int) (Math.random() * 10), person);
			person.addPet(cats[i]);
		}
		
		person.print();
		
		// Trying to add a new cat when the pet list is already full.
		person.addPet(new Cat("FatCat", 2));
		
		
		// Removing 6 of the pets.
		person.removePet(0);
		person.removePet(0);
		person.removePet(0);
		person.removePet(0);
		person.removePet(0);
		person.removePet(0);
		System.out.println("6 cats removed from list.");
		
		person.print();
		System.out.println();
			
		System.out.println(
			String.format("First owned pet is: %s.\nLast owned pet is: %s.", person.getPet(0), person.getPet(person.getNumberOfPets() - 1))
			);

		System.out.println();
		System.out.println("Listing all 20 cats.");
		
		for (Cat cat: cats) {
			cat.print();
		}
	}
}
