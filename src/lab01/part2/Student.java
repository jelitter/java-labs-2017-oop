package lab01.part2;

public class Student {

	private String firstName;
	private String lastName;
	private int mark;
	private String grade;
	
	public Student(String firstName, String lastName, int mark) {
		this.setFirstName(firstName);
		this.setLastName(lastName);;
		this.setMark(mark);;
		this.setGrade(this.mark);
	}
	
	private void setGrade(int mark) {
		if ((mark <= 100) && (mark > 84)) this.grade = "Distinction";
		else if ((mark <= 84) && (mark > 64)) this.grade = "Merit";
		else if ((mark <= 64) && (mark > 39)) this.grade = "Pass";
		else if ((mark <= 39) && (mark >= 0)) this.grade = "Fail";
	}
	
	private String getGrade() {
		return grade;
	}
	
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " received a " + 
		this.getGrade() + " for his mark of " + this.getMark();
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
		this.setGrade(this.mark);
	}

	public void print() {
		System.out.println(this);
	}
	
}
