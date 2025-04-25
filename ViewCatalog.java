package librarysystem;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class ViewCatalog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCatalog frame = new ViewCatalog();
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
	public ViewCatalog() {

		setTitle("View All Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel titleLabel = new JLabel("Book Catalog");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBounds(160, 10, 200, 30);
        contentPane.add(titleLabel);

        // Load books
        ArrayList<Book> books = Book.getAll();
        StringBuilder sb = new StringBuilder();

        for (Book b : books) {
            sb.append("Title: ").append(b.getTitle()).append("\n");
            sb.append("Author: ").append(b.getAuthor()).append("\n");
            sb.append("Genre: ").append(b.getGenre()).append("\n");
            sb.append("Year: ").append(b.getYear()).append("\n");
            sb.append("ISBN: ").append(b.getISBN()).append("\n");
            sb.append("Copies Available: ").append(b.getCopies()).append("\n");
            sb.append("---\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
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
