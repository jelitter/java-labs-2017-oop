package HotelProject.view;
import java.util.Scanner;

import HotelProject.controller.HotelController;

public class Menu {
	
	
	/* --------------------------------
	 *       PROPERTIES
	 * -------------------------------*/
	private static final String SEPARATOR = "________________________________________\n";

	private static final int MENU_TITLE = 0;
	private static final int MENU_RESERVATIONS = 1;
	private static final int MENU_GUESTS = 2;
	private static final int MENU_ROOMS = 3;
	private static final int MENU_EXIT = 4;
	
	private static final int MENU_ADD_RESERVATION = 1;
	private static final int MENU_CANCEL_RESERVATION = 2;
	private static final int MENU_PAY_RESERVATION = 3;
	private static final int MENU_LIST_ACTIVE_RESERVATIONS = 4;
	private static final int MENU_LIST_ALL_RESERVATIONS = 5;
	private static final int MENU_RESERVATION_RETURN = 6;
	
	private static final int MENU_ADD_GUEST = 1;
	private static final int MENU_LIST_ALL_GUESTS = 2;
	private static final int MENU_LIST_ALL_STUDENTS = 3;
	private static final int MENU_LIST_ALL_LECTURERS = 4;
	private static final int MENU_GUEST_RETURN = 5;

	private static final int MENU_LIST_ALL_ROOMS = 1;
	private static final int MENU_LIST_FREE_ROOMS = 2;
	private static final int MENU_LIST_OCCUPIED_ROOMS = 3;
	private static final int MENU_ROOM_RETURN = 4;
	
	public static String[] mainOptions, reservationOptions, guestOptions, roomOptions; 
	public static String[][] menus; 
	private Scanner kb;
	private HotelController hotel;
	
	
	/* --------------------------------
	 *       CONSTRUCTOR
	 * -------------------------------*/
	public Menu() {
		
		mainOptions = new String[] { "MAIN Menu",
				                      "Reservations and Payments",
				                      "Guests",
				                      "Rooms",
				                      "Exit" };
		
	    reservationOptions = new String[] { "Reservations Menu",
							                 "Add Reservation",
							                 "Cancel Reservation",
							                 "Finalize and Pay Reservation",
							                 "List Active Reservations",
							                 "List All Reservations",
							                 "Return to Main Menu" }; 
		
        guestOptions = new String[] { "GUESTS Menu",
        							   "Add guest",
									   "List all guests",
									   "List student guests",
									   "List lecturer guests",
									   "Return to Main Menu" };

        roomOptions = new String[] { "ROOM Menu",
									  "List ALL Rooms",
									  "List Available Rooms",
									  "List Occupied Rooms",
									  "Return to Main Menu" }; 
				
		Menu.menus = new String[][] { mainOptions, reservationOptions, guestOptions, roomOptions };
		this.kb = new Scanner(System.in);
		System.out.println(SEPARATOR);
		hotel = new HotelController();
		System.out.println(SEPARATOR);
		Continue();
	}
	
	public void show(String[] menu) {
		int option = -1;

		do {
			clearScreen();
			System.out.println(SEPARATOR);
			System.out.println("  Hotel Management - " + menu[Menu.MENU_TITLE]);
			System.out.println(SEPARATOR);
			for (int i = 1; i< menu.length; i++) {
				System.out.println("  " + i + ". " + menu[i]);
			}
			System.out.println(SEPARATOR);
			for (int i = 0; i < 20; i++) { System.out.println(); }
			option = this.readOption(menu);

			switch(menu[Menu.MENU_TITLE]) {
				case("MAIN Menu"):	
					handleMain(option);
					break;
					
				case("Reservations Menu"):	
					handleReservations(option);
					break;
					
				case("GUESTS Menu"):
					handleGuests(option);
					break;
					
				case("ROOM Menu"):	
					handleRooms(option);
					break;
					
				default:
					System.out.println("  Other menu.");
					break;
			}
		} while (option != menu.length -1);
	}
	
	
	/* --------------------------------
	 *       METHODS
	 * -------------------------------*/
	
	private void handleMain(int option) {
		switch (option) {

		case(Menu.MENU_RESERVATIONS):
			this.show(Menu.reservationOptions);
		break;
		
		case(Menu.MENU_GUESTS):
			this.show(Menu.guestOptions);
		break;
		
		case(Menu.MENU_ROOMS):
			this.show(Menu.roomOptions);
		break;
		
		case(Menu.MENU_EXIT):
			this.hotel.saveDatabase();
		System.out.println("  Exitting program.");
		break;
		
		default:
			break;
		}
	}

	private void handleRooms(int option) {
		printTitle(roomOptions[option]);
		
		switch (option) {
		case(Menu.MENU_LIST_ALL_ROOMS): {
			hotel.listAllRooms();
			Continue();
		}
		break;

		case(Menu.MENU_LIST_FREE_ROOMS): {
			hotel.listFreeRooms();
			Continue();
		}
		break;

		case(Menu.MENU_LIST_OCCUPIED_ROOMS): {
			hotel.listOccupiedRooms();
			Continue();
		}
		break;

		case(Menu.MENU_ROOM_RETURN): {
			System.out.println("Return...");	
		}
		break;

		default:
			break;
		}		
	}

	private void handleGuests(int option) {
		printTitle(guestOptions[option]);

		switch (option) {
		case(Menu.MENU_ADD_GUEST): {
			String name = "", type = "";
			name = this.readString("guest name (empty to cancel)");
			if (!name.equals(""))
				do {
					type = this.readString("guest type (s for student, l for lecturer, empty to cancel)");
				} while (!type.toLowerCase().equals("s") && !type.toLowerCase().equals("l") && !type.toLowerCase().equals(""));

			if (!type.toLowerCase().equals("") && !type.toLowerCase().equals("")) {
				hotel.addGuest(name, type);
				System.out.println("  Guest added.");
			} else {
				System.out.println("  'Add Guest' Cancelled");
			}
			Continue();
		}
		break;
		
		case(Menu.MENU_LIST_ALL_GUESTS): {
			hotel.listAllGuests();
			Continue();
		}
		break;

		case(Menu.MENU_LIST_ALL_STUDENTS): {
			hotel.listAllStudents();
			Continue();
		}
		break;
		
		case(Menu.MENU_LIST_ALL_LECTURERS): {
			hotel.listAllLecturers();
			Continue();
		}
		break;
		
		case(Menu.MENU_GUEST_RETURN): {
			System.out.println("  Return...");
		}
		break;

		default:
			break;
		}
	}
	
	private void handleReservations(int option) {

		printTitle(reservationOptions[option]);
		switch (option) {

		case(Menu.MENU_ADD_RESERVATION): {
			int roomID, guestID = -1, guests = -1, maxguests;
			
			if (hotel.getNumberOfGuests() == hotel.getMaxOccupants()) {
				System.out.println("  Hotel is currently full ("+ hotel.getMaxOccupants() +"occupants). Cancel or finalize a reservation before adding a new one.");
				break;
			}
			
			do {
				System.out.println("  Available Rooms:");
				hotel.listFreeRooms();
				roomID = this.readInt("room ID (1 to "+ hotel.getNumberOfRooms() +") (-1 to cancel)");
				if ((hotel.getRoomById(roomID) != null) && hotel.getRoomById(roomID).isOccupied())
					System.out.println("Room " + roomID +  " is occupied. Select a different one.");
			} while ((hotel.getRoomById(roomID) == null || hotel.getRoomById(roomID).isOccupied()) && roomID != -1);

			if (roomID != -1) do {
				System.out.println("  GUEST List:");
				hotel.listAllGuests();
				guestID = this.readInt("guest ID (-1 to cancel, -2 to add new guest)");
				if (guestID == -2) {
					handleGuests(Menu.MENU_ADD_GUEST);
				} else if (hotel.getGuestById(guestID) == null && guestID != -1)
					System.out.println("  Guest " + guestID +  " is not in Hotel Guest List. Select a different one or add guest first.");
			} while (hotel.getGuestById(guestID) == null && guestID != -1);

			
			if (roomID != -1 && guestID != -1) do  {
				maxguests = hotel.getRoomById(roomID).getCapacity();
				
				if (hotel.getNumberOfGuests() + maxguests > hotel.getMaxOccupants()) {
					maxguests = hotel.getMaxOccupants() - hotel.getNumberOfGuests();
					// Won't allow more than 'maxOccupants' guests in the Hotel with a new reservation
				}			
				
				guests = this.readInt("number of guests (1 to " + maxguests + ") (-1 to cancel)");
				
				if ((guests < 1 || guests > maxguests) && guestID != -1)
					System.out.println("  Wrong number of guests (Pick 1 to " + maxguests + ") (-1 to cancel)");
				
			} while ((guests < 1 || guests > maxguests) && guestID != -1);

			
			if (guestID != -1 && roomID != -1 && guests != -1) {
				this.hotel.addReservation(roomID, guestID, guests);
				System.out.println("  Reservation added.");
			} else {
				System.out.println("  'Add Reservation' Cancelled");
			}
			Continue();
		}
		break;

		case(Menu.MENU_CANCEL_RESERVATION): {
			int reservationId;
			System.out.println("  Active (Pending) Reservations:");
			hotel.listActiveReservations();
			do {
				reservationId = this.readInt("reservation ID (-1 to exit)");
				if (reservationId != -1) {
					if (hotel.getReservationById(reservationId) ==  null) {
						System.out.println("  Invalid reservation ID. Please select an existing and active reservation.");
					} else if (!hotel.getReservationById(reservationId).isActive() ) {
						System.out.println("  Reservation " + reservationId + " is not pending. Please select an active reservation.");
					}
				}
			} while ((hotel.getReservationById(reservationId) == null || !hotel.getReservationById(reservationId).isActive()) && reservationId != -1);
			if (reservationId != -1) {
				System.out.println("  Reservation cancelled.");
				hotel.getReservationById(reservationId).cancel();
				hotel.listReservation(hotel.getReservationById(reservationId));
			} else {
				System.out.println("  Reservation not cancelled.");
			}
			Continue();
		}
		break;

		case(Menu.MENU_PAY_RESERVATION): {
			int reservationId;
			System.out.println("  Active (Pending) Reservations:");
			hotel.listActiveReservations();
			do {
				reservationId = this.readInt("reservation ID (-1 to cancel)");
				if (reservationId != -1) {
					if (hotel.getReservationById(reservationId) ==  null) {
						System.out.println("  Invalid reservation ID. Please select an existing and active reservation.");
					} else if (!hotel.getReservationById(reservationId).isActive() ) {
						System.out.println("  Reservation " + reservationId + " is not pending. Please select an active reservation.");
					}
				}
			} while ((hotel.getReservationById(reservationId) == null || !hotel.getReservationById(reservationId).isActive()) && reservationId != -1);
			if (reservationId != -1) {
				System.out.println("  Reservation payed and finalized.");
				hotel.getReservationById(reservationId).pay();
				hotel.listReservation(hotel.getReservationById(reservationId));
			} else {
				System.out.println("  Reservation payment cancelled.");
			}
			Continue();
		}
		break;

		case(Menu.MENU_LIST_ALL_RESERVATIONS): {
			hotel.listAllReservations();
			Continue();
		}
		break;

		case(Menu.MENU_LIST_ACTIVE_RESERVATIONS): {
			hotel.listActiveReservations();
			Continue();
		}
		break;
		case(Menu.MENU_RESERVATION_RETURN):
			System.out.println("  Return");
		break;
		default:
			break;
		}

	}

	
	
	public int readOption(String[] menu) {

		int opt = -1;
		Boolean validOption = false;
		
		while (!validOption) {
			System.out.print("  Enter option: ");
			try {
				opt = Integer.parseInt(kb.nextLine());
				if (opt < menu.length && opt > 0) {
					validOption = true;
				} else {
					System.out.println("  Invalid option. Please pick a valid option [1 - " + (menu.length -1) + "]");
				}
			} catch (Exception e) {
				System.out.println("  Invalid option. Please pick a valid option [1 - " + (menu.length -1) + "]");
			} 
		}
		return opt;
	}

	public String readString(String stringName) {
		System.out.print("  Enter " + stringName + ": ");
		String result = kb.nextLine();
		return result;
	}

	public int readInt(String intName) {
		int myInt = -1;
		Boolean validOption = false;
		
		while (!validOption) {
			System.out.print("  Enter " + intName + ": ");
			try {
				myInt = Integer.parseInt(kb.nextLine());
				validOption = true;
			} catch (Exception e) {
				System.out.println("Invalid " + intName + ". Please enter a integer number.");
			} 
		}
		
		return myInt;
	}

	public double readDouble(String doubleName) {
		double myDouble = -1;
		Boolean validOption = false;
		
		while (!validOption) {
			System.out.print("  Enter " + doubleName + ": ");
			try {
				myDouble = Double.parseDouble(kb.nextLine());
				validOption = true;
			} catch (Exception e) {
				System.out.println("Invalid " + doubleName + ". Please enter a double number.");
			} 
		}
		return myDouble;
	}
	
	public void Continue() {
		System.out.println("\nPress <ENTER> to continue...");
		kb.nextLine();
	}
	

	public final static void clearScreen() {
		for (int i = 0; i < 50; i++) { System.out.println(); }
	}
	
	public static void printTitle(String s) {
		clearScreen();
		System.out.println();
		System.out.println(SEPARATOR);
		System.out.println("    " + s);
		System.out.println(SEPARATOR);
		System.out.println();
	}
	
}
