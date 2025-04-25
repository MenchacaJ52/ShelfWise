package librarysystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PayFee extends JFrame {
	 private JPanel contentPane;
	    private JComboBox<Student> studentDropdown;
	    private JLabel feeLabel;

	    public PayFee() {
	        setTitle("Pay Fees");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 500, 250);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);

	        JLabel titleLabel = new JLabel("Pay Student Fees");
	        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	        titleLabel.setBounds(140, 10, 250, 30);
	        contentPane.add(titleLabel);

	        JLabel selectLabel = new JLabel("Select Student:");
	        selectLabel.setBounds(30, 60, 100, 20);
	        contentPane.add(selectLabel);

	        // Filter only students who owe something
	        ArrayList<Student> feeOwingStudents = Student.getAll().stream()
	                .filter(s -> s.getFee() > 0)
	                .collect(Collectors.toCollection(ArrayList::new));

	        studentDropdown = new JComboBox<>(feeOwingStudents.toArray(new Student[0]));
	        studentDropdown.setBounds(140, 60, 300, 25);
	        contentPane.add(studentDropdown);

	        feeLabel = new JLabel("Fee: $0.00");
	        feeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        feeLabel.setBounds(140, 90, 300, 25);
	        contentPane.add(feeLabel);

	        // Update label on selection
	        studentDropdown.addActionListener(e -> {
	            Student selected = (Student) studentDropdown.getSelectedItem();
	            if (selected != null) {
	                feeLabel.setText("Fee: $" + String.format("%.2f", selected.getFee()));
	            }
	        });

	        JButton payButton = new JButton("Pay Fee");
	        payButton.setBounds(90, 140, 120, 30);
	        payButton.addActionListener((ActionEvent e) -> {
	            Student selected = (Student) studentDropdown.getSelectedItem();
	            if (selected != null) {
	                selected.clearFee();
	                Student.updateFee(selected);
	                JOptionPane.showMessageDialog(this,
	                        "Fee paid for " + selected.getLastName());
	                dispose();
	                demoframe d = new demoframe();
	                d.main(null);
	                new PayFee(); // Reload to update the list
	            }
	        });
	        contentPane.add(payButton);

	        JButton mainMenuButton = new JButton("Main Menu");
	        mainMenuButton.setBounds(250, 140, 120, 30);
	        mainMenuButton.addActionListener((ActionEvent e) -> {
	            dispose();
	            demoframe d = new demoframe();
	            d.main(null);
	        });
	        contentPane.add(mainMenuButton);

	        // Show initial fee
	        if (studentDropdown.getItemCount() > 0) {
	            studentDropdown.setSelectedIndex(0);
	        } else {
	            feeLabel.setText("No students owe fees.");
	        }
	        setVisible(true);
	    }
	    public static void main(String[] args) {
	        new PayFee();
	    }

}
