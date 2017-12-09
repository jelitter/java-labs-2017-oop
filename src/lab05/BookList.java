package lab05;

public class BookList extends ObjectList {
	
	private static final long serialVersionUID = 1L;

	public BookList(int max) {
		super(max);
	}
	
	public void add(Book b) { this.add((Object) b); }
	public Book getBook(int n) { return (Book) this.getObject(n); }
	
	public String search(int n) {
	    Book b = (Book) this.getObject(n);
	    return b.getISBN();
	}
	
	public String removeBook(int n) {
	    Book b = (Book) this.getObject(n);
	    String ret = b.getISBN();
	    this.remove(n);
	    return ret;
	}
	
	public String removeBook(Book b) {
		String ISBN = b.getISBN();
		Object o = (Object) b;
		this.remove(o);
	    return ISBN;
	}
	
	public Boolean removeBookByISBN(String ISBN) {
		Book b = null;
		for (Object o: this.getList()) {
			b = (Book) o;
			
			if (b.getISBN().trim().equals(ISBN.trim())) {
				this.getList().remove(o);
				return true;
			}
		}
		return false;
	}
	
	public Book getBookByISBN(String ISBN) {
		Book b = null;
		for (Object o: this.getList()) {
			b = (Book) o;
			
			if (b.getISBN().trim().equals(ISBN.trim())) {
				return b;
			}
		}
		return b;
	}
	
	public double calculateYearlyBookPayment() {
	    double payment = 0;
	    for (Object o: getList()) {
	        Book b = (Book) o;
	        payment += b.getPrice();
	    }
	    return (double) Math.round(payment*100.0)/100.0; // rounded to 2 decimals
	}
	
	public String toString() {
		String result = "";
		for (Object o: this.getList()) {
			if (!result.equals(""))
				result += ", ";
			result += ((Book) o).getTitle();
		}
		return result;
	}
}
