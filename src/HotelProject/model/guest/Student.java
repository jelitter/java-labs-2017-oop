package HotelProject.model.guest;

import java.io.Serializable;

public class Student extends Guest implements Serializable {

	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	public Student(String name) {
		super(name, GuestType.STUDENT);
	}
}
