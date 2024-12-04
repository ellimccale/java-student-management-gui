package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import app.model.Major;
import app.model.Student;
import app.model.StudentManager;
import app.view.Dialog;
import app.view.MainScrollPane;

/**
 * The main application frame for the student management system.
 * <p>
 * This class extends {@link JFrame} and serves as the entry point for the GUI.
 * It initializes the main content pane, which includes a title at the top and a
 * scrollable panel displaying student information in the center.
 * 
 * @author Elli Steck
 * @see app.model.Student
 * @see app.model.StudentManager
 * @see app.view.Dialog
 * @see app.view.MainScrollPane
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 4276895503191674509L;
	private JPanel contentPane;
	private Dialog dialog;
	private MainScrollPane mainScrollPane;

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
		this.setTitle("Student Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 500);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));

		this.setContentPane(contentPane);

		dialog = new Dialog(getLayeredPane());

		// NORTH: Title and "Add student" button
		JPanel panelLayoutNorth = new JPanel();
		panelLayoutNorth.setLayout(new BoxLayout(panelLayoutNorth, BoxLayout.Y_AXIS));
		panelLayoutNorth.setBorder(new EmptyBorder(0, 0, 15, 0));

		JLabel lblTitle = new JLabel("University Name");
		lblTitle.setFont(lblTitle.getFont().deriveFont(Font.BOLD, 24f));
		lblTitle.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelLayoutNorth.add(lblTitle);

		JButton btnAddStudent = new JButton("Add student");
		btnAddStudent.addActionListener(e -> {
			dialog.init("Add Student", createPanelAddStudent(), 600, 300);
		});
		panelLayoutNorth.add(btnAddStudent);

		contentPane.add(panelLayoutNorth, BorderLayout.NORTH);

		// CENTER: Main panel with student information
		mainScrollPane = new MainScrollPane();
		mainScrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
		contentPane.add(mainScrollPane, BorderLayout.CENTER);

	}

	/**
	 * Creates and returns a {@link JPanel} representing the "Add Student" form.
	 * <p>
	 * Upon submission, a new {@link Student} is created and added to the system via
	 * {@link StudentManager#addStudent(Student)}. The student list in
	 * {@code MainScrollPane} is updated dynamically.
	 *
	 * @return a {@link JPanel} containing the "Add Student" form and buttons
	 */
	private JPanel createPanelAddStudent() {
		JPanel panelAddStudent = new JPanel();
		panelAddStudent.setLayout(new GridLayout(0, 2));
		panelAddStudent.setBorder(new EmptyBorder(20, 20, 20, 20));

		// Row 1
		panelAddStudent.add(new JLabel("First name*"));
		panelAddStudent.add(new JLabel("Last name*"));

		// Row 2
		JTextField fieldFirstName = new JTextField();
		panelAddStudent.add(fieldFirstName);

		JTextField fieldLastName = new JTextField();
		panelAddStudent.add(fieldLastName);

		// Row 3
		panelAddStudent.add(new JLabel("Academic year*"));
		panelAddStudent.add(new JLabel("Major*"));

		// Row 4
		JTextField fieldAcademicYear = new JTextField();
		panelAddStudent.add(fieldAcademicYear);

		Major[] majorsList = Major.class.getEnumConstants();
		JComboBox<Major> selectMajor = new JComboBox<>(majorsList);
		panelAddStudent.add(selectMajor);

		// Row 5
		panelAddStudent.add(new JLabel("* Required fields"));

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 0, 0));

		JButton btnCancelAddStudent = new JButton("Cancel");
		btnCancelAddStudent.addActionListener(e -> {
			((JDialog) btnCancelAddStudent.getTopLevelAncestor()).dispose();
		});
		buttonPanel.add(btnCancelAddStudent);

		JButton btnConfirmAddStudent = new JButton("Add student");
		btnConfirmAddStudent.addActionListener(e -> {
			try {
				String firstName = fieldFirstName.getText();
				String lastName = fieldLastName.getText();
				Major major = (Major) selectMajor.getSelectedItem();
				int academicYear = Integer.valueOf(fieldAcademicYear.getText());

				Student newStudent = new Student(firstName, lastName, major, academicYear);

				StudentManager.addStudent(newStudent);
				mainScrollPane.addStudentPanel(newStudent);
				mainScrollPane.getVerticalScrollBar().setValue(
						mainScrollPane.getVerticalScrollBar().getMaximum());
			} catch (NumberFormatException | IOException ex) {
				ex.printStackTrace();
			}

			((JDialog) btnConfirmAddStudent.getTopLevelAncestor()).dispose();
		});
		buttonPanel.add(btnConfirmAddStudent);

		panelAddStudent.add(buttonPanel);

		return panelAddStudent;
	}

}
