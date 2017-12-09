package lab03.part3;
import java.util.ArrayList;

public class BookList {
	
	private ArrayList<Book> list;
	
	public BookList() {
		this.list = new ArrayList<Book>();
	}
	
	public void add(Book b) {
		this.list.add(b);
	}

}
