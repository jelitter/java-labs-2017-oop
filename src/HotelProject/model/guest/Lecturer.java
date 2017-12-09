package HotelProject.model.guest;

import java.io.Serializable;

public class Lecturer extends Guest implements Serializable {
	
	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	public Lecturer(String name) {
		super(name, GuestType.LECTURER);
	}
}
