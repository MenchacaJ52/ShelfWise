package librarysystem;
import java.util.ArrayList;
public class Student {
	private String lastName;
    private String id;
    private String grade;

    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String lastName, String id, String grade) {
        this.lastName = lastName;
        this.id = id;
        this.grade = grade;
        students.add(this);
    }
    public static void addStudent(String lastName, String id, String grade) {
        Student newStudent = new Student(lastName, id, grade);
    }
    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        return lastName;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
}