package lab05;

public class Main {
	
	private static final String FILENAME = "lecturer.ser";
	
	public static void main(String[] args) {
		Lecturer lecturer = null;
		LecturerList myLecturers = (LecturerList) FileStorage.readObject(FILENAME);
							
		if (myLecturers == null) {
			System.out.println("  Lecture List file not found. Creating empty one.");
 			FileStorage.storeObject(new LecturerList(10), FILENAME);
		}
		else {
			Lecturer.setNumberOfLecturers(myLecturers.getList().size());
			System.out.println("  Lecturer List read from file: " + myLecturers.getList().size() + " lecturers.");
		}
	
        
        int option = -1;
        Menu menu = new Menu();
        
        
        while (option != 0) {
            menu.show();
            option = menu.readOption();
            Menu.printTitle(option);
            
            switch (option) {
	            case (Menu.MENU_EXIT):
	            	FileStorage.storeObject(myLecturers, FILENAME); // Saving data before exiting.
	                System.out.println("  Exiting program.");
        		break;
        		
        		
            	case (Menu.MENU_ADD_LECTURER):
            		myLecturers.add((Object) new Lecturer(menu.readString("name")));
            		System.out.println("  Lecturer added.");
            		break;
            		
            		
            	case (Menu.MENU_FIND_LECTURER_BY_ID):
            		lecturer = myLecturers.findById(menu.readInt("lecturer ID"));
            		if (lecturer != null)
            			System.out.println("\n  Found lecturer\n" + lecturer);
            		else
            			System.out.println("\n  Lecturer not found.");
            		break;
            		
            		
            	case (Menu.MENU_ADD_BOOK_TO_LECTURER):
            		lecturer = myLecturers.findById(menu.readInt("lecturer ID"));
            		if (lecturer != null) {
            			System.out.println("  Found lecturer\n" + lecturer);
            			
            			if (lecturer.getBooks().getTotal() < Lecturer.MAX_BOOKS) {
            				lecturer.addBook(new Book(
            						menu.readString("book title"),
            						menu.readDouble("book price"),
            						menu.readString("ISBN"),
            						menu.readString("author")
            						));
            				System.out.println("  Book added.");
            			} else {
            				System.out.println("  This lecturer already has max number of books ("+ lecturer.getBooks().getTotal() +").");
            				System.out.println("  Remove 1 or more books before adding new ones.");
            			}
            		}
            		else
            			System.out.println("  Lecturer not found.");
            		
            		break;
            		
            		
            	case (Menu.MENU_REMOVE_BOOK_FROM_LECTURER):
            		
            		lecturer = myLecturers.findById(menu.readInt("lecturer ID"));
	            	if (lecturer != null) {
	            		System.out.println("  Found lecturer\n" + lecturer);

	            		if (lecturer.getBooks().removeBookByISBN(menu.readString("ISBN"))) {
	            			System.out.println("  Book removed.");
	            		} else {
	            			System.out.println("  Not removed: Book not found on this lecturer's list.");
	            		}
	            	}
	            	else
	            		System.out.println("  Lecturer not found.");


            	break;
            		
            		
            	case (Menu.MENU_SEARCH_BOOK_BY_ISBN):
            		
            		Book b = null;
            		String ISBN = menu.readString("ISBN");
            	
	            	for (Object o: myLecturers.getList()) {
	        			Lecturer l = (Lecturer) o;
	        			b = l.getBooks().getBookByISBN(ISBN);
	        			
	        			if (b != null) { // book found
	        				System.out.println("  Book found in collection from lecturer ID" + l.getID() + ": " + l.getName() + "\n" + b);
	        				break;
	        			}
	            	}
	            	if (b == null) System.out.println("Book not found in any lecturer's collection.");
            		break;
            		
            		
            	case (Menu.MENU_YEARLY_BOOK_PAYMENT):

            		for (Object o: myLecturers.getList()) {
            			Lecturer l = (Lecturer) o;
            			System.out.println("  Lecturer "+ l.getID() + ": " +
            					l.getName() + 
            					"  => Yearly payment: " + 
            					l.getBooks().calculateYearlyBookPayment() + " euros.");
            		}
            		
            		break;
            		
            		
            	case (Menu.MENU_PRINT_ALL_BOOKS):
            		System.out.println(myLecturers.getAllDetails());
            		break;
            		
            		
            	default:
            		break;
            }
        }
	}
}
