package librarysystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class demoframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demoframe frame = new demoframe();
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
	public demoframe() {
		Library lib = new Library();
		setTitle("Welcome to Shelfwise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to ShelfWise");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(77, 11, 278, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook bk = new AddBook();
				bk.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(49, 53, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Catalog");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCatalog cat = new ViewCatalog();
				cat.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(239, 53, 125, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent addStud = new AddStudent();
				addStud.main(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(49, 121, 135, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Students");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudents viewStud = new ViewStudents();
				viewStud.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(239, 121, 125, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Checkout Book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCheckout nc = new NewCheckout();
				nc.main(null);
				dispose();
			}
		});
		btnNewButton_4.setBounds(49, 87, 135, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Return Book");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook rb = new ReturnBook();
				rb.main(null);
				dispose();
			}
		});
		btnNewButton_5.setBounds(239, 87, 125, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Quit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_6.setBounds(165, 196, 107, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("View Checkouts");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCheckouts v = new ViewCheckouts();
				v.main(null);
				dispose();
			}
		});
		btnNewButton_7.setBounds(49, 155, 135, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Simulate Time");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeSimulator tm = new TimeSimulator();
				tm.main(null);
			}
		});
		btnNewButton_8.setBounds(239, 155, 125, 23);
		contentPane.add(btnNewButton_8);
	}
}
