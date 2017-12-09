package lab01.part3;

public class Person {

	private int stars;
	private String phone;
	private String name;
	
	public Person(int stars, String phone, String name) {
		this.setStars(stars);;
		this.setPhone(phone);;
		this.setName(name);;
	}
	
	public void jump() {
		System.out.println("I jumped");
	}
	
	public void jump(int n) {
		System.out.println("I jumped " + n + " times!");
	}

	public String toString() {
		return this.getName() + " with phone number " + this.getPhone() + " has " + this.getStars() + " stars.";
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println(this);
	}
}
