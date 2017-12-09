package HotelProject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import HotelProject.model.guest.*;
import HotelProject.model.room.*;

public class Hotel implements Serializable {

	/* --------------------
	 *   PROPERTIES
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	public static final int MAX_OCCUPANTS = 27;
	public static final int NUMBER_OF_ROOMS = 15;

	private List<Room> rooms;
	private List<Guest> guests;
	private List<Reservation> reservations;
	
	
	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	public Hotel() {

		this.rooms = new ArrayList<Room>();
		this.guests = new ArrayList<Guest>();
		this.reservations = new ArrayList<Reservation>();
		
		// 3 Suites
		for (int r=0; r < 3; r++) {
			rooms.add(new SuiteRoom());
		}
		
		// 6 Double Rooms
		for (int r=3; r < 9; r++) {
			rooms.add(new DoubleRoom());
		}
		
		// 6 Single Rooms
		for (int r=9; r < 15; r++) {
			rooms.add(new SingleRoom());
		}
	}
	
	
	/* --------------------
	 *   METHODS
	 * --------------------*/
	public List<Room> getRooms() { return rooms;	}
	public void setRooms(List<Room> rooms) { this.rooms = rooms;	}
	
	public List<Guest> getGuests() { return guests; }
	public void setGuests(List<Guest> guests) { this.guests = guests; }
	
	public List<Reservation> getReservations() { return reservations; }
	public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
	

}
