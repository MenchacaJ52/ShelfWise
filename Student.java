package librarysystem;
import java.sql.*;
import java.util.ArrayList;

public class Student {
    private String lastName;
    private String id;
    private String grade;
    private double fee;

    public Student(String lastName, String id, String grade) {
        this.lastName = lastName;
        this.id = id;
        this.grade = grade;
        this.fee = 0;
    }

    // Getters and setters
    public String getLastName() { return lastName; }
    public String getId() { return id; }
    public String getGrade() { return grade; }
    public double getFee() { return fee; }

    public void addFee(double f) { fee += f; }
    public void clearFee() { fee = 0; }

    @Override
    public String toString() {
    	return lastName + " (ID: " + id + ")";
    }

    // Save student to MySQL database
    public static void save(Student s) {
        String sql = "INSERT INTO student (id, name, grade, fee) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.id);
            stmt.setString(2, s.lastName);
            stmt.setString(3, s.grade);
            stmt.setDouble(4, s.fee);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // Load all students from MySQL
    public static ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY name";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("grade")
                );
                s.fee = rs.getDouble("fee");
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Load failed: " + e.getMessage());
        }
        return list;
    }
    public static void updateFee(Student s) {
        String sql = "UPDATE student SET fee = ? WHERE name = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, s.getFee());
            stmt.setString(2, s.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Student fee update failed: " + e.getMessage());
        }
    }
}