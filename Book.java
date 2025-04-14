package librarysystem;
import java.util.ArrayList;
public class Book {
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private int year;
    private int copies;

    private static ArrayList<Book> catalog = new ArrayList<>();

    public Book(String title, String author, String genre, String ISBN, int year, int copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.year = year;
        this.copies = copies;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    public int getCopies() {
        return copies;
    }

    public boolean isAvailable() {
        return copies > 0;
    }

    public void reduceCopy() {
        if (copies > 0) {
            copies--;
        }
    }

    public void increaseCopy() {
        copies++;
    }

    @Override
    public String toString() {
        return title + " (" + copies + " copies available)";
    }

    public static void addBook(String title, String author, String genre, String ISBN, int year, int copies) {
        catalog.add(new Book(title, author, genre, ISBN, year, copies));
    }

    public static ArrayList<Book> getCatalog() {
        return catalog;
    }
}