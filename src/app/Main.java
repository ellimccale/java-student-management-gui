package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import app.ui.DialogPanel;
import app.ui.MainScrollPane;

/**
 * The main application frame for the student management system.
 * <p>
 * This class extends {@link JFrame} and serves as the entry point for the
 * graphical user interface. It initializes the main content pane, which
 * includes a title at the top and a scrollable panel displaying student
 * information in the center.
 * 
 * @author Aidan Reed
 * @author Elli Steck
 * @see app.ui.DialogPanel
 * @see app.ui.MainScrollPane
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 4276895503191674509L;
	private JPanel contentPane;
	private DialogPanel dialogPanel;

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
	 * The frame is initialized with a scrollable {@link MainScrollPane} in the
	 * center to display student information.
	 */
	public Main() {
		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		// NORTH: Title and "Add student" button
		JPanel panelLayoutNorth = new JPanel();
		panelLayoutNorth.setLayout(new GridLayout(2, 1));
		panelLayoutNorth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JLabel lblTitle = new JLabel("University Name");
		panelLayoutNorth.add(lblTitle);

		JButton btnAddStudent = new JButton("Add student");
		panelLayoutNorth.add(btnAddStudent);

		JButton btnOther = new JButton("Other button");
		panelLayoutNorth.add(btnOther);

		contentPane.add(panelLayoutNorth, BorderLayout.NORTH);

		// CENTER: Main panel with student information
		JScrollPane scrollPaneMain = new MainScrollPane();
		contentPane.add(scrollPaneMain, BorderLayout.CENTER);

		// Dialogs
		dialogPanel = new DialogPanel(getLayeredPane());

		btnAddStudent.addActionListener(e -> {
			dialogPanel.showDialog("Add student", createAddStudentPanel());
		});

		btnOther.addActionListener(e -> {
			dialogPanel.showDialog("Other panel", createOtherPanel());
		});

	}

	private JPanel createAddStudentPanel() {
		JPanel panelAddStudent = new JPanel();

        panelAddStudent.setPreferredSize(new Dimension(300, 200));
        panelAddStudent.setBackground(Color.WHITE);
        panelAddStudent.setLayout(new GridLayout(3, 1));
        panelAddStudent.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        panelAddStudent.add(new JLabel("Student name:"));
        panelAddStudent.add(new JTextField());

        JButton btnCloseAddStudent = new JButton("Close");
        btnCloseAddStudent.addActionListener(e -> {
            ((JDialog) btnCloseAddStudent.getTopLevelAncestor()).dispose();
        });
        panelAddStudent.add(btnCloseAddStudent);

        return panelAddStudent;
    }

	private JPanel createOtherPanel() {
		JPanel panelOther = new JPanel();

		panelOther.setPreferredSize(new Dimension(300, 600));
		panelOther.setBackground(Color.RED);
		panelOther.setLayout(new GridLayout(3, 1));
		panelOther.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

		panelOther.add(new JLabel("This is another panel"));

        JButton btnCloseOther = new JButton("Close");
        btnCloseOther.addActionListener(e -> {
            ((JDialog) btnCloseOther.getTopLevelAncestor()).dispose();
        });
        panelOther.add(btnCloseOther);

        return panelOther;
	}

}
