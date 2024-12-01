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
 * Represents the main scrollable area of the student management application.
 * <p>
 * This class extends {@link JScrollPane} and displays a header row with a
 * scrollable list of student panels, where each student panel represents a
 * single student's information.
 * 
 * @author Aidan Reed
 * @author Elli Steck
 * @see app.model.StudentManager
 * @see app.ui.StudentPanel
 */
public class MainScrollPane extends JScrollPane {

	private static final long serialVersionUID = 8079487866761426457L;

	/**
	 * Constructs a new {@link MainScrollPane}, initializing the header and viewport
	 * with student information.
	 * <p>
	 * Horizontal scrolling is disabled to maintain a clean layout.
	 */
	public MainScrollPane() {
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel panelScrollHeader = createPanelScrollHeader();
		setColumnHeaderView(panelScrollHeader);

		JPanel panelScrollViewport = createPanelScrollViewport();
		setViewportView(panelScrollViewport);
	}

	/**
	 * Creates the header row for the scroll pane, displaying column labels.
	 * 
	 * @return a {@link JPanel} containing the column header labels
	 */
	private JPanel createPanelScrollHeader() {
		JPanel panelScrollHeader = new JPanel();
		panelScrollHeader.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelScrollHeader.add(lblStudentId);

		JLabel lblLastFirstName = new JLabel("Last, First");
		panelScrollHeader.add(lblLastFirstName);

		JLabel lblMajor = new JLabel("Major");
		panelScrollHeader.add(lblMajor);

		JLabel lblAcademicYear = new JLabel("Academic year");
		lblAcademicYear.setHorizontalAlignment(SwingConstants.RIGHT);
		panelScrollHeader.add(lblAcademicYear);

		return panelScrollHeader;
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
	private JPanel createPanelScrollViewport() {
		JPanel panelScrollViewport = new JPanel();
		panelScrollViewport.setLayout(new GridLayout(0, 1, 0, 0));

		try {
			Set<Student> students = StudentManager.getStudents();

			if (students.isEmpty()) {
				JLabel lblNoStudents = new JLabel("No students found.");
				lblNoStudents.setHorizontalAlignment(SwingConstants.CENTER);
				panelScrollViewport.add(lblNoStudents);
			} else {
				for (Student st : students) {
					JPanel panelThisStudent = new StudentPanel(st);
					panelScrollViewport.add(panelThisStudent);
				}
			}
		} catch (IOException e) {
			JLabel lblErrorLoading = new JLabel("Error loading students: " + e.getMessage());
			lblErrorLoading.setHorizontalAlignment(SwingConstants.CENTER);
			panelScrollViewport.add(lblErrorLoading);
			e.printStackTrace();
		}

		return panelScrollViewport;
	}

}
