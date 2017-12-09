package lab03.part2;
import java.util.ArrayList;

public class Person {
	
	private static final int MAX_PETS = 20;
	private String name;
	private int age;
	private String address;
	private ArrayList<Cat> pets;
	private int numberOfPets;
	
	public Person(String name, int age, String address) {
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
		this.setPets(new ArrayList<Cat>(MAX_PETS));
		this.numberOfPets = 0;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private void setPets(ArrayList<Cat> arrayList) {
		this.pets = arrayList;
	}
	public void addPet(Cat pet) {
		// If pet list is not full, pet is added to the list, and this person set as owner for the pet.
		if (this.getNumberOfPets() < MAX_PETS) {
			pet.setOwner(this);
			this.pets.add(pet);
			this.incNumberOfPets();
		} else {
			System.out.println("Pet \"" + pet + "\" was not added. Pet list is full.");
		}
	}
	public int getNumberOfPets() {
		return this.numberOfPets;
	}

	public void removePet(Cat pet) {
		// If pet list is not empty, pet is removed from the list, and pet owner is set to none (null).
		if (this.getNumberOfPets() > 0) {
			pet.setOwner(null);
			this.pets.remove(pet);
			this.decNumberOfPets();
		} else {
			System.out.println("Pet \"" + pet + "\" was not removed. Pet list is empty.");
		}	
	}
	public void removePet(int petIndex) {
		// If pet list is not empty, pet is removed from the list, and pet owner is set to none (null).
		if (this.getNumberOfPets() > 0) {
			this.getPet(petIndex).setOwner(null);
			this.pets.remove(petIndex);
			this.decNumberOfPets();
		} else {
			System.out.println("Pet number \"" + petIndex + "\" was not removed. Pet list is empty.");
		}	
	}
	
	private void decNumberOfPets() {
		this.numberOfPets--;
	}
	private void incNumberOfPets() {
		this.numberOfPets++;
	}
	
	public String toString() {
		return String.format("Person named %s with age %d has %d pets.", this.getName(), this.getAge(), this.getNumberOfPets());
	}

	public Cat getPet(int i) {
		return this.pets.get(i);
	}

	public void print() {
		System.out.println(this);		
	}
}
