package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TimeSimulator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeSimulator frame = new TimeSimulator();
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
	public TimeSimulator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(154, 127, 130, 20);
		contentPane.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Simulate Time");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(157, 25, 144, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Day Number: ");
		lblNewLabel_1.setBounds(32, 130, 112, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer day = (Integer) spinner.getValue();
				ArrayList<Checkout> checkouts = Checkout.getAll();

				for (Checkout c : checkouts) {
				    int newPeriod = c.getPeriod() - day;

				    if (newPeriod < 0) {
				        int overdueDays = Math.abs(newPeriod);
				        double fee = overdueDays * 0.25;

				        Student s = c.getStudent();
				        s.addFee(fee);
				        Student.updateFee(s);
				    }
				    c.setPeriod(newPeriod);
				    Checkout.updatePeriod(c);
				}
				dispose();
				new demoframe().main(null);
			}
		});
		btnNewButton.setBounds(164, 158, 89, 23);
		contentPane.add(btnNewButton);
	}
}
