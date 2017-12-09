package lab02.part2;

public class MainTest {

	public static void main(String[] args) {

		Actor[] actors = new Actor[2];
		Film[] films = new Film[3];
		
		// First Actor
		actors[0] = new Actor("Jack Nicholson", "Miami", 74);
		
		films[0] = new Film("Wolf");
		films[1] = new Film("As good as it gets");
		films[2] = new Film("One flew over the Cuckoo's Nest");
		
		actors[0].setMyFilm(films);	
		actors[0].print();
		
		// Second Actor	
		actors[1] = new Actor("Violante Placido", "Bologna", 38);
		
		films[0] = new Film("The american");
		films[1] = new Film("Ghost Rider spirit of vengeance");
		films[2] = new Film("Barah Aanan");
		
		actors[1].setMyFilm(films);	
		actors[1].print();
	}

}
