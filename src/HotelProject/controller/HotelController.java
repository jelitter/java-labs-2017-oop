package HotelProject.controller;
import HotelProject.model.Hotel;
import HotelProject.model.Reservation;
import HotelProject.model.guest.Guest;
import HotelProject.model.guest.Guest.GuestType;
import HotelProject.model.room.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class HotelController {

	/* --------------------------------
	 *       PROPERTIES
	 * -------------------------------*/
	private static final String HOTELFILENAME = "hotel.data";
	private int maxOccupants;
	private Hotel hotel;

	
	/* --------------------------------
	 *       CONSTRUCTOR
	 * -------------------------------*/
	
	public HotelController() {
		hotel = loadDatabase();
		
		if (hotel == null) {
			hotel = createNewDatabase();
			this.addSampleData();
 			System.out.println("  New database created.");
		}
		else {
			System.out.println("  Hotel database loaded from: " + HOTELFILENAME
			                + "\n  Rooms: "+ hotel.getRooms().size() 
					        + "\n  Guests in DB: " + hotel.getGuests().size() 
					        + "\n  Active reservations: " + this.getActiveReservations().size()
					        + "\n  Total guests in Hotel: " + this.getNumberOfGuests());
		}
		this.setMaxOccupants(Hotel.MAX_OCCUPANTS);
	}


	/* --------------------------------
	 *       METHODS
	 * -------------------------------*/
	
	public int getMaxOccupants() { return this.maxOccupants; }
	public void setMaxOccupants(int maxOccupants) { this.maxOccupants = maxOccupants; }
	
	public void addSampleData() {
		
		// Adding sample guests
		this.addGuest("John", GuestType.LECTURER);
		this.addGuest("Peter", GuestType.LECTURER);
		this.addGuest("Bryan", GuestType.STUDENT);
		this.addGuest("Albert", GuestType.STUDENT);
		this.addGuest("Mary", GuestType.STUDENT);
		
		// Adding sample reservations and modifying them
		this.addReservation(10, 5, 1);
		this.addReservation(11, 2, 2);
		this.addReservation(1, 1, 3);
		this.payReservation(2);
		this.cancelReservation(3);
	}
	
	
	/* --------------------------------
	 *       DATABASE Methods
	 * -------------------------------*/
	public Hotel createNewDatabase() {
		Hotel hotel = new Hotel();
		FileStorage.storeObject(hotel, HOTELFILENAME);
		return hotel;
	}
	
	public Hotel loadDatabase() {
		Hotel hotel = (Hotel) FileStorage.readObject(HOTELFILENAME); 
		
		if (hotel != null) {
			Reservation.setTotal(hotel.getReservations().size());  // Setting static Reservation _id so new created reservations won't have repeated Ids.
			Guest.setTotal(hotel.getGuests().size());               // Setting static Guest _id so new created guests won't have repeated Ids.
		}
		return hotel;
	}
	
	public void saveDatabase() {
		FileStorage.storeObject(this.hotel, HOTELFILENAME);
	}
	
	
	/* --------------------------------
	 *       ROOMS
	 * -------------------------------*/
	
	public int getNumberOfRooms() { return this.hotel.getRooms().size(); }

	public void listAllRooms() {
		System.out.println();
		for (Room r: this.hotel.getRooms()) {
			r.print();
		}
		System.out.println();
	}

	public void listFreeRooms() {
		Predicate<Room> byOccupation = room -> (!room.isOccupied());
		List<Room> freeRooms = this.hotel.getRooms().stream().filter(byOccupation).collect(Collectors.<Room> toList());
		System.out.println();
		for (Room r: freeRooms) {
				r.print();
		}
		if (freeRooms.size() == 0)
			System.out.println("  No free rooms at the moment.");
		System.out.println();
	}
	
	public void listOccupiedRooms() {
		Predicate<Room> byOccupation = room -> (room.isOccupied());
		List<Room> occupiedRooms = this.hotel.getRooms().stream().filter(byOccupation).collect(Collectors.<Room> toList());
		System.out.println();
		for (Room r: occupiedRooms) {
				r.print();
		}		
		if (occupiedRooms.size() == 0)
			System.out.println("  No occupied rooms at the moment.");
		System.out.println();
	}

	public Room getRoomById(int roomId) {
		Predicate<Room> byId = room -> (room.getId() == roomId);
		try {
			Room room = this.hotel.getRooms().stream().filter(byId).findFirst().get();
			return room;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/* --------------------------------
	 *       GUESTS
	 * -------------------------------*/

	public Guest getGuestById(int guestId) {
		Predicate<Guest> byId = guest -> (guest.getId() == guestId);
		try {
			Guest guest = this.hotel.getGuests().stream().filter(byId).findFirst().get();
			return guest;
		} catch (Exception e) {
			return null;
		}
	}

	// Overloaded method
	public void addGuest(String name, GuestType type) {
		Guest guest = new Guest(name, type);
		this.hotel.getGuests().add(guest);
	}
	public void addGuest(String name, String type) {
		GuestType gtype = type.equals("s") ? GuestType.STUDENT : GuestType.LECTURER;
		Guest guest = new Guest(name, gtype);
		this.hotel.getGuests().add(guest);
	}

	public void listAllGuests() {
		System.out.println();
		for (Guest g: this.hotel.getGuests()) {
			g.print();
		}
		System.out.println();
	}

	public void listAllStudents() {
		Predicate<Guest> byType = guest -> guest.getType() == GuestType.STUDENT;
		List<Guest> students = this.hotel.getGuests().stream().filter(byType).collect(Collectors.<Guest> toList());
		System.out.println();
		for (Guest g: students) {
				g.print();
		}	
		System.out.println();
	}

	public void listAllLecturers() {
		Predicate<Guest> byType = guest -> guest.getType() == GuestType.LECTURER;
		List<Guest> lecturers = this.hotel.getGuests().stream().filter(byType).collect(Collectors.<Guest> toList());
		System.out.println();
		for (Guest g: lecturers) {
				g.print();
		}		
		System.out.println();
	}
	
	
	/* --------------------------------
	 *       RESERVATIONS
	 * -------------------------------*/
	
	public void addReservation(int roomId, int guestId, int guests) {
		Reservation reservation = new Reservation(roomId, guestId, guests);
		Room room = this.getRoomById(roomId);
		Guest guest = this.getGuestById(guestId);
		Double price = (double) (reservation.getNumberOfGuests() * room.getRate()) * (100.0 - guest.getPercentDiscount()) / 100; 
		reservation.setPrice(price);
		room.occupy();
		this.hotel.getReservations().add(reservation);
		listReservation(reservation);
	}
	
	// Added this method in Controller since "Reservation" class has no access to "Room" and "Guest" classes.
	public void listReservation(Reservation reservation) {
		Room room   = this.getRoomById(reservation.getRoomID());
		Guest guest = this.getGuestById(reservation.getGuestID());
		String status = reservation.isActive() ? "Active" : reservation.isPaid() ? "Finalized" : "Cancelled" ;		
		//  Active    : Active and not paid
		//  Finalized : Not active and paid
		//  Cancelled : Not active and not paid
		
		System.out.println("  Reservation ID: " + reservation.getId() 
						  + ", Guest ID: " + guest.getId() + " ("+ guest.getName() + ", "+ guest.getType().toString().toLowerCase() +"), " 
						  + "Room ID: "+ room.getId() + " (" + room.getType().toString().toLowerCase() + "). "
						  + "People: " + reservation.getNumberOfGuests() + " "
						  + "Reservation status: " + status + ", "
						  + "Price: " + reservation.getPrice() + ", Paid: " + (reservation.isPaid() ? "Yes" : "No") );
	}

	public void listAllReservations() {
		System.out.println();
		for (Reservation reservation: this.hotel.getReservations()) {
			listReservation(reservation);
		}
		System.out.println();
	}
	
	public void listActiveReservations() {
		System.out.println();
		for (Reservation reservation: this.getActiveReservations()) {
			listReservation(reservation);
		}		
		System.out.println();
	}
	
	private List<Reservation> getActiveReservations() {
		Predicate<Reservation> byStatus = reservation -> reservation.isActive();
		List<Reservation> activeReservations = this.hotel.getReservations().stream().filter(byStatus).collect(Collectors.<Reservation> toList());
		return activeReservations;
	}
	
	public int getNumberOfGuests() {
		int numberOfGuests = 0;
		for (Reservation r: this.getActiveReservations()) {
				numberOfGuests += r.getNumberOfGuests();
		}
		return numberOfGuests;
	}

	public Reservation getReservationById(int resId) {
		Predicate<Reservation> byId = reservation -> (reservation.getId() == resId);
		try {
			Reservation res = this.hotel.getReservations().stream().filter(byId).findFirst().get();
			return res;
		} catch (Exception e) {
			return null;
		}
	}

	public void payReservation(int resId) {
		Reservation reservation = this.getReservationById(resId);
		Room room = this.getRoomById(reservation.getRoomID());
		reservation.pay();
		room.free();
	}

	public void cancelReservation(int resId) {
		Reservation reservation = this.getReservationById(resId);
		Room room = this.getRoomById(reservation.getRoomID());
		reservation.cancel();
		room.free();
	}
}
