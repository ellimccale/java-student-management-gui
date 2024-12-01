package app.ui;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import app.model.Student;
import app.model.StudentManager;

/**
 * Represents the main panel of the student management application.
 * <p>
 * This panel is a {@link JScrollPane} that displays a header row and a
 * scrollable list of student panels, where each student panel represents a
 * single student's information.
 * <p>
 * The panel includes:
 * <ul>
 * <li>A column header view displaying the labels for "Student ID", "Last,
 * First", "Major", and "Academic Year".</li>
 * <li>A viewport view containing a list of {@link StudentPanel} objects, each
 * displaying a student's details.</li>
 * </ul>
 * 
 * @author Aidan Reed
 * @author Elli Steck
 * @see app.model.Student
 * @see app.ui.StudentPanel
 */
public class MainPanel extends JScrollPane {

	private static final long serialVersionUID = 8079487866761426457L;

	/**
	 * Constructs a new {@code MainPanel}, initializing the header and the viewport
	 * with student information.
	 * <p>
	 * The scroll pane disables horizontal scrolling to maintain a clean layout.
	 */
	public MainPanel() {
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll pane header
		JPanel mainPanelHeader = createMainPanelHeader();
		this.setColumnHeaderView(mainPanelHeader);

		// Scroll pane viewport
		JPanel mainPanelRows = createMainPanelRows();
		this.setViewportView(mainPanelRows);
	}

	/**
	 * Creates the header row for the scroll pane, displaying column labels.
	 * 
	 * @return a {@link JPanel} containing the column header labels
	 */
	private JPanel createMainPanelHeader() {
		JPanel mainPanelHeader = new JPanel();
		mainPanelHeader.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblId = new JLabel("Student ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		mainPanelHeader.add(lblId);

		JLabel lblLastFirst = new JLabel("Last, First");
		mainPanelHeader.add(lblLastFirst);

		JLabel lblMajor = new JLabel("Major");
		mainPanelHeader.add(lblMajor);

		JLabel lblAcademicYear = new JLabel("Academic year");
		lblAcademicYear.setHorizontalAlignment(SwingConstants.RIGHT);
		mainPanelHeader.add(lblAcademicYear);

		return mainPanelHeader;
	}

	/**
	 * Creates the scrollable list of student rows, with each row represented by a
	 * {@link StudentPanel}.
	 * <p>
	 * If an error occurs while loading the students, the panel will display an
	 * error message instead of student rows.
	 * 
	 * @return a {@link JPanel} containing a vertical list of {@link StudentPanel}
	 *         objects or an error message
	 */
	private JPanel createMainPanelRows() {
		JPanel mainPanelRows = new JPanel();
		mainPanelRows.setLayout(new GridLayout(0, 1, 0, 0));

		try {
			Set<Student> students = StudentManager.getStudents();

			if (students.isEmpty()) {
				JLabel noStudentsLabel = new JLabel("No students found.");
				noStudentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
				mainPanelRows.add(noStudentsLabel);
			} else {
				for (Student st : students) {
					JPanel studentPanel = new StudentPanel(st);
					mainPanelRows.add(studentPanel);
				}
			}
		} catch (IOException e) {
			JLabel errorLabel = new JLabel("Error loading students: " + e.getMessage());
			errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanelRows.add(errorLabel);
			e.printStackTrace();
		}

		return mainPanelRows;
	}

}
