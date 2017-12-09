package lab03.part2;

public class Cat {
	
	private String name;
	private int age;
	private Person owner;
	
	public Cat(String name, int age) {
		this.setName(name);;
		this.setAge(age);
		this.setOwner(null);
	}
	
	public Cat(String name, int age, Person owner) {
		this.setName(name);;
		this.setAge(age);
		this.setOwner(owner);
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

	public Person getOwner() {
		return this.owner;
	}
	public String getOwnerName() {
		return (this.owner != null) ? this.owner.getName() : "No owner";
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public String toString() {
		return String.format("Cat named %s with age %d is owned by %s", this.getName(), this.getAge(), this.getOwnerName());
	}

	public void print() {
		System.out.println(this);		
	}
	
}
