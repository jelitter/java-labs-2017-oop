package lab02.part1;

public class TestDVD
{
	public static void main(String[] args)	{
		DVD  dvd1 = new DVD(); // Added default constructor setting all properties to empty strings.
		dvd1.setTitle("Song Bird"); // Added public method 'setTitle' to modify private property 'title'
		dvd1.setGenre("Blues");
		dvd1.setArtist("Eva Cassidy");
		dvd1.print();

		DVD dvd2 = new DVD("Johnny B. Goode", "Chuck Berry");
		dvd2.print(); // added public 'toString' and 'print' methods to display object's info
	}
}
