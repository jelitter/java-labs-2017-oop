package HotelProject.model;

import java.io.Serializable;

public class Reservation implements Serializable {
	
	/* --------------------
	 *   PROPERTIES
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	private static int _id = 0;
	private int id;
	private int roomID;
	private int guestID;
	private int numberOfGuests;
	private double price;
	private Boolean active;      // Reservations can be cancelled and not paid
	private Boolean paid;
	
	
	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	public Reservation(int roomID, int guestID, int numberOfGuests) {
		this.setRoomID(roomID);
		this.setGuestID(guestID);
		this.setNumberOfGuests(numberOfGuests);
		this.setActive(true);
		this.setPaid(false);
		this.setId(++_id);
		this.setPrice(0);  // Price will be set from the Controller who has access to Room and Guest classes.
	}

	
	/* --------------------
	 *   METHODS 
	 * --------------------*/
	public static void setTotal(int i) { Reservation._id = i; }  // Used from HotelController.loadDatabase() so new created reservations won't have repeated Ids.
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; 	}
	
	private void setRoomID(int roomID) { this.roomID = roomID; }
	public int getRoomID() { return this.roomID; }
	
	private void setGuestID(int guestID) { this.guestID = guestID; }
	public int getGuestID() { return this.guestID; }

	private void setNumberOfGuests(int numberOfGuests) { this.numberOfGuests = numberOfGuests; }
	public int getNumberOfGuests() { return this.numberOfGuests; }
	
	public void cancel() { this.active = false; }
	public Boolean isActive() { return this.active;	}
	public void setActive(Boolean active) { this.active = active; }
	
	public void setPaid(Boolean paid) { this.paid = paid; }
	public Boolean isPaid() { return this.paid;	}
	
	public String toString() { return "Reservation ID: " + this.getId() + ", Room ID: " + this.getRoomID() + ", Guest ID: " + this.getGuestID(); }

	public double getPrice() { return this.price; }
	public void setPrice(double price) { this.price = price; 	}
	
	public void pay() {
		this.setPaid(true);
		this.setActive(false);
	}



}
