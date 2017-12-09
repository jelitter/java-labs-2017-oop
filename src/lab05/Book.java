package lab05;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String ISBN;
	private String author;
	private double price;

	public Book(String title, double price, String ISBN, String author) {
		this.setTitle(title);
		this.setISBN(ISBN);
		this.setAuthor(author);
		this.setPrice(price);
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public String getISBN() { return ISBN;	}
	public void setISBN(String ISBN) { this.ISBN = ISBN; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	
	public String toString() {
		return "  Title : " + this.getTitle() + "\n" +
				"  Author: " + this.getAuthor() + "\n" +
				"  ISBN  : " + this.getISBN() + "\n" +
				"  Price : " + this.getPrice() + " euros\n";
	}
}
