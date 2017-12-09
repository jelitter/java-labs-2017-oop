package lab05;

//import java.io.Serializable;

public class LecturerList extends ObjectList {

	private static final long serialVersionUID = 1L;
	public LecturerList(int max) { super(max); }
	
	public String getAllDetails() {
		String val = "";
		
		for(Object o:getList()) {
			Lecturer lect = (Lecturer)o;
			val += "== LECTURER =================\n";
			val += (lect.getBooks().getTotal() > 0) ? lect + "\n  == BOOKS ============\n" : lect;
			
			for(Object n:lect.getBooks().getList()) {
				Book b = (Book)n;
				val += b + "\n";
			}
			val += "\n";
		}
		return val;
	}

	public Lecturer findById(int id) {
		Lecturer lect = null;
		for (Object o: this.getList()) {
			lect = (Lecturer) o;
			if (lect.getID() == id)
				return lect;
		}
		return null;
	}
}
