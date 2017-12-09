package lab02.part1;

public class DVD {

	private String title, genre, artist;

	public DVD(String title, String artist) {
		this.setTitle(title);
		this.setArtist(artist);;
		this.setGenre("");
	}

	public DVD() {
		this.setTitle("");
		this.setArtist("");;
		this.setGenre("");
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		return "Title: " + this.getTitle() + " - Artist: " + this.getArtist() + " - Genre: " + this.getGenre();
	}

	public void print() {
		System.out.println(this);
	}
}
