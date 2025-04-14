package librarysystem;

import java.util.ArrayList; //used to store and manage both books and students
import java.util.Collections; //adds sorting functionality for lists
import java.util.Comparator; //adds sorting functionality
import java.util.HashMap; //stores key value pairs for tracking books
import java.util.Scanner; //for reading inputs

public class Library {
    private ArrayList<Book> catalog = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<String, String> checkedOutBooks = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    
    //asks user to enter TAG + ISBN and reads the input
    public void addBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();


        
    }
   
    
    public void checkOutBook() {
    	if (catalog.isEmpty()) {
    		System.out.println("No books available.");
    		return;
    		
    	}
    	if (students.isEmpty()) {
    		System.out.println("No students registered.");
    		return;
    	}
    	
    	System.out.println("Avalable Books:");
    	for (Book book : catalog) {

    		}
    	}
    	

    
    public void returnBook() {
    	if(checkedOutBooks.isEmpty()) {
    		System.out.println("No books checked out: ");
    		return;
    		
    	}
    	
    	System.out.println("Checked Out Books: ");
    	for (String bookTitle : checkedOutBooks.keySet()) {
    		System.out.println(bookTitle + " (Checked out by: " + checkedOutBooks.get(bookTitle)+ ")");
    		
    	}
    	System.out.print("Enter the title of book to return: ");
    	String bookTitle = scanner.nextLine();
    	
    	if (checkedOutBooks.containsKey(bookTitle)) {
    		checkedOutBooks.remove(bookTitle);
    		System.out.println("The book \"" + bookTitle + "\" has been returned.");
    	}else {
    		System.out.println("Book not found in checked out list.");
    		
    	}
    	
    }
       
    

    public void viewCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("No books in catalog.");
            return;
        }
        



        System.out.println("Book Catalog:");
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    public void startLibrarySystem() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("-------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. View Catalog");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Check Out Book");
            System.out.println("6. Return Book");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewCatalog();
                    break;
                   
                case 5:
                    checkOutBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                	System.out.println("Exiting Program...");
                    scanner.close(); 
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}