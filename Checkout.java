package librarysystem;
import java.util.ArrayList;
public class Checkout {
	private Student student;
    private Book book;
    private int period;

    private static ArrayList<Checkout> checkouts = new ArrayList<>();

    public Checkout(Student student, Book book, int period) {
        this.student = student;
        this.book = book;
        this.period = period;
        checkouts.add(this);
        book.reduceCopy(); // reduce 1 copy on checkout
    }
    public Book getBook() {
        return book;
    }
    public static void returnBook(Checkout c) {
        checkouts.remove(c);
        c.getBook().increaseCopy(); // Use the actual getter method
    }

    public static ArrayList<Checkout> getCheckouts() {
        return checkouts;
    }
    public Student getStudent() {
        return student;
    }
    public String toString() {
        return "Student: " + student.getLastName() +
               "\nBook: " + book.getTitle() +
               "\nPeriod: " + period + " days\n---\n";
    }
}