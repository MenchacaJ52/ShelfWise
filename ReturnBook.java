package librarysystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReturnBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
	    demoframe main = new demoframe();
	    setTitle("Return a Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel titleLabel = new JLabel("Return Book");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        titleLabel.setBounds(160, 10, 200, 30);
        contentPane.add(titleLabel);

        JLabel selectLabel = new JLabel("Select a book to return:");
        selectLabel.setBounds(30, 60, 200, 20);
        contentPane.add(selectLabel);

        // Get all checkouts
        ArrayList<Checkout> checkouts = Checkout.getCheckouts();
        JComboBox<Checkout> checkoutDropdown = new JComboBox<>(checkouts.toArray(new Checkout[0]));
        checkoutDropdown.setBounds(30, 90, 420, 25);
        contentPane.add(checkoutDropdown);

        // Renderer: show book title and student last name
        checkoutDropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Checkout) {
                    Checkout checkout = (Checkout) value;
                    setText(checkout.getBook().getTitle() + " – " + checkout.getStudent().getLastName());
                }
                return this;
            }
        });

        // Submit button
        JButton returnButton = new JButton("Return Book");
        returnButton.setBounds(80, 140, 150, 30);
        contentPane.add(returnButton);

        // Main Menu button
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(260, 140, 150, 30);
        contentPane.add(mainMenuButton);

        // Logic for returning book
        returnButton.addActionListener((ActionEvent e) -> {
            Checkout selected = (Checkout) checkoutDropdown.getSelectedItem();
            if (selected != null) {
                Checkout.returnBook(selected);
                JOptionPane.showMessageDialog(this,
                        "Book \"" + selected.getBook().getTitle() + "\" returned by " +
                                selected.getStudent().getLastName() + "!");
                dispose();
                main.main(null);
                new ReturnBook(); // reloads the frame to update the list
            } else {
                JOptionPane.showMessageDialog(this, "No checkout selected.");
            }
        });

        // Logic to go back to main menu
        mainMenuButton.addActionListener((ActionEvent e) -> {
            dispose();
            main.main(null);
        });
	}
}
