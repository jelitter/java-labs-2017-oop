package HotelProject.model.room;

import java.io.Serializable;

public class SuiteRoom extends Room implements Serializable {

	/* --------------------
	 *   PROPERTIES
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	private static final int RATE = 150; 
	private static final int CAPACITY = 3;
	
	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	public SuiteRoom() {
		super(RATE);
		this.setCapacity(CAPACITY);
		this.setType(RoomType.SUITE);
	}
}
