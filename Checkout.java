package librarysystem;
import java.util.ArrayList;
import java.sql.*;
public class Checkout {
	private Student student;
    private Book book;
    private int period;

    public Checkout(Student student, Book book, int period) {
        this.student = student;
        this.book = book;
        this.period = period;
    }

    public Student getStudent() { return student; }
    public Book getBook() { return book; }
    public int getPeriod() { return period; }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return book.getTitle() + " – " + student.getLastName() + " (" + period + " days)";
    }

    // Save checkout to MySQL
    public static void save(Checkout c) {
        String sql = "INSERT INTO checkout (student, title, period) VALUES (?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getStudent().getLastName());
            stmt.setString(2, c.getBook().getTitle());
            stmt.setInt(3, c.getPeriod());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Checkout save failed: " + e.getMessage());
        }
    }

    // Load all checkouts from MySQL
    public static ArrayList<Checkout> getAll() {
        ArrayList<Checkout> list = new ArrayList<>();
        String sql = "SELECT * FROM checkout";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ArrayList<Student> students = Student.getAll();
            ArrayList<Book> books = Book.getAll();

            while (rs.next()) {
                String lastName = rs.getString("student");
                String title = rs.getString("title");
                int period = rs.getInt("period");

                Student student = students.stream()
                        .filter(s -> s.getLastName().equals(lastName))
                        .findFirst()
                        .orElse(null);

                Book book = books.stream()
                        .filter(b -> b.getTitle().equals(title))
                        .findFirst()
                        .orElse(null);

                if (student != null && book != null) {
                    Checkout checkout = new Checkout(student, book, period);
                    list.add(checkout);
                }
            }

        } catch (SQLException e) {
            System.out.println("Checkout load failed: " + e.getMessage());
        }

        return list;
    }


    public static void delete(Checkout c) {
        String sql = "DELETE FROM checkout WHERE student = ? AND title = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getStudent().getLastName());
            stmt.setString(2, c.getBook().getTitle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Checkout delete failed: " + e.getMessage());
        }
    }

    // Update period in the database
    public static void updatePeriod(Checkout c) {
        String sql = "UPDATE checkout SET period = ? WHERE student = ? AND title = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getPeriod());
            stmt.setString(2, c.getStudent().getLastName());
            stmt.setString(3, c.getBook().getTitle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Checkout update failed: " + e.getMessage());
        }
    }
    

}