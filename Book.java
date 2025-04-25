package librarysystem;
import java.util.ArrayList;
import java.sql.*;
public class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private int year;
    private int copies;

    public Book(String isbn, String title, String author, String genre, int year, int copies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.copies = copies;
    }

    // Getters
    public String getISBN() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public int getCopies() { return copies; }

    public boolean isAvailable() {
        return copies > 0;
    }

    public void reduceCopy() {
         copies--;
    }

    public void increaseCopy() {
        copies++;
    }

    @Override
    public String toString() {
        return title + "(Copies Available:" + copies+")";
    }

    // Save book to MySQL
    public static void save(Book b) {
        String sql = "INSERT INTO book (isbn, title, author, genre, year, copies) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, b.isbn);
            stmt.setString(2, b.title);
            stmt.setString(3, b.author);
            stmt.setString(4, b.genre);
            stmt.setInt(5, b.year);
            stmt.setInt(6, b.copies);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Book insert failed: " + e.getMessage());
        }
    }

    // Load all books from MySQL
    public static ArrayList<Book> getAll() {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY title";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book b = new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("year"),
                        rs.getInt("copies")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Book load failed: " + e.getMessage());
        }

        return list;
    }
    public static void updateCopies(Book b) {
        String sql = "UPDATE book SET copies = ? WHERE title = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, b.getCopies());
            stmt.setString(2, b.getTitle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Book copy update failed: " + e.getMessage());
        }
    }
}