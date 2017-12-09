package HotelProject.model.guest;

import java.io.Serializable;

public class Guest implements Serializable  {
	
	/* --------------------
	 *   PROPERTIES 
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	public static enum GuestType { STUDENT, LECTURER }
	private static int _id = 0;
	private String name;
	private int id;
	private GuestType type;
	private double percentDiscount;
	

	/* --------------------
	 *   CONSTRUCTOR 
	 * --------------------*/

	public Guest(String name, GuestType type) {
		this.setName(name);
		this.id = ++_id;
		this.setType(type);
		this.setPercentDiscount(this.getType() == GuestType.LECTURER ? 10.0 : 0.0);
	}

	
	/* --------------------
	 *   METHODS 
	 * --------------------*/
	public static void setTotal(int i) { Guest._id = i; }  // Used from HotelController.loadDatabase() so new created guests won't have repeated Ids.

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public GuestType getType() {	return type; }
	public void setType(GuestType type) { this.type = type; }
	
	public double getPercentDiscount() { return this.percentDiscount; }
	public void setPercentDiscount(double percentDiscount) { this.percentDiscount = percentDiscount; }

	public String toString() {
		return "  Guest ID: " + this.getId() + ", Name: " + this.getName() + ", Type: " + this.getType() + ", Discount: " + this.getPercentDiscount() + " %"; 
	}
	public void print() { System.out.println(this); }
}
