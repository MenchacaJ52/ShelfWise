package librarysystem;

import java.util.ArrayList;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudents extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudents frame = new ViewStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewStudents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Get all students
        ArrayList<Student> students = new ArrayList<>(Student.getStudents());
        students.sort(Comparator.comparing(Student::getLastName));

        // Convert to display format
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append("Name: ").append(s.getLastName()).append("\n");
            sb.append("ID: ").append(s.getId()).append("\n");
            sb.append("Grade: ").append(s.getGrade()).append("\n");
            sb.append("---\n");
        }

        // Display in JTextArea with scroll
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 414, 200);
        contentPane.add(scrollPane);

        // Close Button (optional)
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(160, 220, 120, 30);
        closeButton.addActionListener(e -> {
            dispose(); // close this frame
            demoframe d = new demoframe(); // back to main menu
            d.main(null);
        });
        contentPane.add(closeButton);


	}    
}
