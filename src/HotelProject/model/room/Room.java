package HotelProject.model.room;

import java.io.Serializable;

public class Room implements Serializable  {

	/* --------------------
	 *   PROPERTIES 
	 * --------------------*/
	
	private static final long serialVersionUID = 1L;
	public static enum RoomType { 
		SUITE, DOUBLE, SINGLE; 
		
//		@Override
//		public String toString() {
//			switch(this) {
//				case SUITE: return "suite";
//				case DOUBLE: return "double";
//				case SINGLE: return "single";
//				default: return "";
//			}
//		}
	}
	private static int _id; 
	private int rate;
	private int capacity;
	private int id;
	private RoomType type;
	private Boolean occupied;
	
	
	/* --------------------
	 *   CONSTRUCTOR 
	 * --------------------*/
	public Room(int rate) {
		this.setRate(rate);
		this.free();
		this.setId(++_id);
	}
	
	
	/* --------------------
	 *   METHODS 
	 * --------------------*/
	
	public void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	
	public void setCapacity(int capacity) { this.capacity = capacity; }
	public int getCapacity() { return this.capacity; }
	
	public Boolean isOccupied() { return this.occupied; }
	public void occupy() { this.occupied = true; }
	public void free() { this.occupied = false; }
	
	public int getRate() { return rate; }
	public void setRate(int rate) { this.rate = rate; }
	
	public RoomType getType() { return this.type; }
	public void setType(RoomType type) { this.type = type; }

	public String toString() {
		return "  Room ID: " + this.getId() 
		      + ", Type: " + this.getType() 
		      + ", Ppp: " + this.getRate()
		      + ", Capacity: " + this.getCapacity() 
		      + ", Occupied: " + (this.isOccupied() ? "Yes" : "No"); 
	}
	public void print() { System.out.println(this); }
}
