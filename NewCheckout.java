package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;

import librarysystem.Student;

public class NewCheckout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCheckout frame = new NewCheckout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewCheckout() {
		demoframe d = new demoframe();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Student> students = Student.getAll();
		students.sort(Comparator.comparing(Student::getLastName));
		JComboBox<Student> studentDropdown = new JComboBox<>(students.toArray(new Student[0]));
        studentDropdown.setBounds(91, 59, 291, 25);
        contentPane.add(studentDropdown);
		
		JLabel lblNewLabel = new JLabel("New Checkout");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(114, 11, 218, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Student");
		lblNewLabel_1.setBounds(13, 64, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSelectBook = new JLabel("Select Book");
		lblSelectBook.setBounds(13, 100, 78, 14);
		contentPane.add(lblSelectBook);
		
		ArrayList<Book> books = Book.getAll();
		ArrayList<Book> availableBooks = new ArrayList<>();

		for (Book b : books) {
		    if (b.isAvailable()) {
		        availableBooks.add(b);
		    }
		}

		JComboBox<Book> bookDropdown = new JComboBox<>(availableBooks.toArray(new Book[0]));
		bookDropdown.setBounds(100, 100, 250, 25);
		contentPane.add(bookDropdown);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Checkout Period");
		lblNewLabel_2.setBounds(13, 142, 137, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(160, 145, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 Student selectedStudent = (Student) studentDropdown.getSelectedItem();
		         Book selectedBook = (Book) bookDropdown.getSelectedItem();
		         int period = Integer.parseInt(textField.getText());

		         if (selectedBook != null && selectedBook.getCopies() > 0) {
		        	    Checkout c = new Checkout(selectedStudent, selectedBook, period);
		        	    Checkout.save(c);
		        	    selectedBook.reduceCopy();
		        	    Book.updateCopies(selectedBook);

		        	    d.main(null);
		        	    dispose();
		        	}

		    }
		});
		btnNewButton.setBounds(91, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				d.main(null);
			}
		});
		btnNewButton_1.setBounds(243, 180, 107, 23);
		contentPane.add(btnNewButton_1);
	}
}
