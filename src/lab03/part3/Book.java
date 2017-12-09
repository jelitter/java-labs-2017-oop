package lab03.part3;

public class Book {

	private String title;
	private int ISBN;
	private String author;
	private double price;
	
	
	public Book(String title, int ISBN, String author, double price) {
		this.setTitle(title);
		this.setISBN(ISBN);
		this.setAuthor(author);
		this.setPrice(price);
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
