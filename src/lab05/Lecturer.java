package lab05;

import java.io.Serializable;

public class Lecturer implements Serializable {

	private static final long serialVersionUID = 1L;
	static final int MAX_BOOKS = 3;
	
	static int _id = 0;
	private int id;
	private String name;
	private BookList books;
	
	public Lecturer(String name) {
		this.setName(name);
		this.setId();
		this.books = new BookList(MAX_BOOKS);
	}

	private void setName(String name) { this.name = name; }
	public String getName() { return this.name;	}
	
	public static void setNumberOfLecturers(int n) {
		// To be used upon loading Lecturerlist from disk to reflect number of Lecturers on the list.
		Lecturer._id = n;
	}
	private void setId() { this.id = ++_id; }
	
	
	public int getID() { return this.id; }
	public void addBook(Book b) { 
		if (this.books.getTotal() < Lecturer.MAX_BOOKS)
			this.books.add(b); 
	}
	
	public void removeBook(Book b) { this.books.remove((Object) b); }
	
	public BookList getBooks() { return this.books; }

	public String toString() { 
		return "  Lecturer ID   : " + this.getID() + "\n" +
				"  Lecturer Name : " + this.getName() + "\n" +
				"  " + this.getBooks().getList().size() + " books       " + ((this.getBooks().getList().size() > 0) ? ": " + this.getBooks() + "\n" : "\n");
	}
	public void print() { System.out.println(this); }
}
