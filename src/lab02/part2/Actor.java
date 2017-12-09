package lab02.part2;

public class Actor {

	private String name;
	private String address;
	private int age;
	private Film[] myFilm;

	public Actor(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Film[] getMyFilm() {
		return myFilm;
	}

	public void setMyFilm(Film[] myFilm) {
		this.myFilm = myFilm.clone();
	}

	public String toString() {
		String result = getName() + " who's " + getAge() + " and lives in " + getAddress() + "\nFilms: ";
		
		for (Film f: getMyFilm()) {
			result += "\"" + f.toString() + "\", ";
		}
		
		return result + "\n";
	}
	
	public void print() {
		System.out.println(this);
	}

}
