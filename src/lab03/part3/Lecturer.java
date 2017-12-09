package lab03.part3;

public class Lecturer {

	public static final int MAXNOOFBOOKS = 15;
	
	private String name;
	private int id;
	private BookList books;
	
	public Lecturer(String name, int id) {
		this.setName(name);
		this.setId(id);
	}

	private void setName(String name) {
		this.name = name;		
	}
	public String getName() {
		return this.name;
	}
	private void setId(int id) {
		this.id = id;		
	}
	public int getId() {
		return this.id;
	}
	
	public void addBook(Book b) {
		this.books.add(b);
	}
	
	public BookList getBookList() {
		return this.books;
	}
}
