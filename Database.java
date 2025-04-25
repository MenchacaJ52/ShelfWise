package librarysystem;
import java.sql.*;
import java.io.*;

public class Database {
	private static final String URL = "jdbc:mysql://localhost:3306/shelfwise";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Set your MySQL password here

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
