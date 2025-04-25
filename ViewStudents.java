package librarysystem;

import java.util.ArrayList;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.*;
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
        setBounds(100, 100, 450, 325);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Get all students
        ArrayList<Student> students = Student.getAll();
        StringBuilder sb = new StringBuilder();

        for (Student s : students) {
            sb.append("Name: ").append(s.getLastName()).append("\n");
            sb.append("ID: ").append(s.getId()).append("\n");
            sb.append("Grade: ").append(s.getGrade()).append("\n");
            sb.append("Fee: $").append(String.format("%.2f", s.getFee())).append("\n");
            sb.append("---\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 400, 230);
        contentPane.add(scrollPane);
        
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(150, 250, 150, 30); // adjust location as needed
        mainMenuButton.addActionListener(e -> {
            dispose(); // close ViewStudents window
            demoframe main = new demoframe(); // open main menu
            main.main(null);
        });
        contentPane.add(mainMenuButton);


	}    
}
