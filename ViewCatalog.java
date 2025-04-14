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
import javax.swing.border.EmptyBorder;

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

		ArrayList<Book> catalog = new ArrayList<>(Book.getCatalog());
		catalog.sort(Comparator.comparing(Book::getTitle));
        // Convert to display format
        StringBuilder sb = new StringBuilder();
        for (Book s : catalog) {
            sb.append("Title: ").append(s.getTitle()).append("\n");
            sb.append("Author: ").append(s.getAuthor()).append("\n");
            sb.append("Genre: ").append(s.getGenre()).append("\n");
            sb.append("Year of Publication: ").append(s.getYear()).append("\n");
            sb.append("ISBN: ").append(s.getISBN()).append("\n");
            sb.append("Number of Copies: ").append(s.getCopies()).append("\n");
            sb.append("Availability: ").append(s.isAvailable()).append("\n");
            sb.append("---\n");
        }
        // Frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Create JTextArea and add formatted text
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        // Add JTextArea to a ScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 414, 200);
        contentPane.add(scrollPane);

        // Close Button
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(160, 220, 120, 30);
        contentPane.add(closeButton);

        // Close current window and go back to DemoFrame
        closeButton.addActionListener(e -> {
            dispose();  // Close this frame
            demoframe main = new demoframe();
			 main.main(null); // Open main menu (DemoFrame)
        });


	}

}
