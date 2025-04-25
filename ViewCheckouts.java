package librarysystem;

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
import java.awt.EventQueue;
import java.util.ArrayList;
import librarysystem.Checkout;
import javax.swing.*;
import java.awt.*;

public class ViewCheckouts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCheckouts frame = new ViewCheckouts();
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
	public ViewCheckouts() {
		 setTitle("View All Checkouts");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 500, 400);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);

	        JLabel titleLabel = new JLabel("Current Checkouts");
	        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	        titleLabel.setBounds(150, 10, 250, 30);
	        contentPane.add(titleLabel);

	        ArrayList<Checkout> checkouts = Checkout.getAll();
	        StringBuilder sb = new StringBuilder();

	        for (Checkout c : checkouts) {
	            sb.append("Student: ").append(c.getStudent().getLastName()).append("\n");
	            sb.append("Book: ").append(c.getBook().getTitle()).append("\n");
	            sb.append("Period: ").append(c.getPeriod()).append(" days\n");
	            sb.append("---\n");
	        }

	        JTextArea textArea = new JTextArea(sb.toString());
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        scrollPane.setBounds(10, 50, 460, 250);
	        contentPane.add(scrollPane);

	        JButton mainMenuButton = new JButton("Main Menu");
	        mainMenuButton.setBounds(170, 310, 140, 30);
	        mainMenuButton.addActionListener(e -> {
	            dispose();
	            new demoframe().main(null);
	        });
	        contentPane.add(mainMenuButton);
    }

}
