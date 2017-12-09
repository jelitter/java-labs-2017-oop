package HotelProject.model.room;

import java.io.Serializable;

public class SingleRoom extends Room implements Serializable {

	/* --------------------
	 *   PROPERTIES
	 * --------------------*/
	private static final long serialVersionUID = 1L;
	private static final int RATE = 75; 
	private static final int CAPACITY = 1;
	
	/* --------------------
	 *   CONSTRUCTOR
	 * --------------------*/
	public SingleRoom() {
		super(RATE);
		this.setCapacity(CAPACITY);
		this.setType(RoomType.SINGLE);

	}
}
