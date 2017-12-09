package HotelProject.model.room;

import java.io.Serializable;

public class DoubleRoom extends Room implements Serializable {


	/* --------------------
	 *   PROPERTIES
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	private static final int RATE = 100; 
	private static final int CAPACITY = 2;

	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	public DoubleRoom() {
		super(RATE);
		this.setCapacity(CAPACITY);
		this.setType(RoomType.DOUBLE);
	}
}
