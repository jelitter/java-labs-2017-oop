package lab02.part2;

public class Film {
	
	private String name;
	private String code;

	public Film(String name ) {
		this.name = name;
		this.code = "";
		
		String letters[] = this.name.split(" ");
		for (String s:  letters) {
			this.code += s.substring(0,1);
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String toString() {
		return this.getName() + " (" + this.getCode() + ")";
	}
	public void print() {
		System.out.println(this);
	}

}
