package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import app.ui.MainPanel;

/**
 * The main application frame for the student management system.
 * <p>
 * This class extends {@link JFrame} and serves as the entry point for the
 * graphical user interface. It initializes the main content pane, which
 * includes a title at the top and a scrollable panel displaying student
 * information in the center.
 * <p>
 * The layout is organized using {@link BorderLayout}:
 * <ul>
 * 		<li><b>NORTH:</b> Displays the title of the application.</li>
 * 		<li><b>CENTER:</b> Displays the main content area, which includes a
 * 		{@link MainPanel} for student information.</li>
 * </ul>
 * 
 * @author Aidan Reed
 * @author Elli Steck
 * @see app.ui.MainPanel
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructs the main application frame.
	 * <p>
	 * The frame is initialized with a scrollable {@link MainPanel} in the center to
	 * display student information.
	 */
	public Main() {
		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		// NORTH: Application title
		JLabel lblTitle = new JLabel("University Name");
		contentPane.add(lblTitle, BorderLayout.NORTH);

		// CENTER: Main panel with student information
		JScrollPane scrollPane = new MainPanel();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}
