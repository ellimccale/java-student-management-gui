package app.ui;

import java.awt.GridLayout;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import app.model.Major;
import app.model.Student;

/**
 * Represents the main panel of the student management application.
 * 
 * <p>
 * This panel is a {@link JScrollPane} that displays a header row and a
 * scrollable list of student panels, where each student panel represents a
 * single student's information.
 * </p>
 * 
 * <p>
 * The panel includes:
 * </p>
 * 
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

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code MainPanel}, initializing the header and the viewport
	 * with student information.
	 * 
	 * <p>
	 * The scroll pane disables horizontal scrolling to maintain a clean layout.
	 * </p>
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
	 * 
	 * <p>
	 * The students are added in insertion order and displayed vertically.
	 * </p>
	 * 
	 * @return a {@link JPanel} containing a vertical list of {@link StudentPanel}
	 *         objects
	 */
	private JPanel createMainPanelRows() {
		JPanel mainPanelRows = new JPanel();
		mainPanelRows.setLayout(new GridLayout(0, 1, 0, 0));

		// Hardcoded for test
		Set<Student> students = new LinkedHashSet<>();
		Collections.addAll(
				students,
				new Student("Sylvia", "Ashbaugh", Major.BIOT, 2021),
				new Student("Louella", "Gilroy", Major.INDS, 2022),
				new Student("Khaldun", "Nassar", Major.PTAS, 2020),
				new Student("Katherine", "Blum", Major.DENT, 2019),
				new Student("Andrew", "Williams", Major.RELS, 2022),
				new Student("Eric", "Hurst", Major.WELD, 2024),
				new Student("Liu", "Sun", Major.MARK, 2023),
				new Student("Romano", "Prieto", Major.GEOS, 2023),
				new Student("Allison", "Miyanohara", Major.ECON, 2024),
				new Student("Jorge", "Evangelista", Major.CHEM, 2022),
				new Student("Kenisha", "Davis", Major.FASH, 2023),
				new Student("Emile", "Bak", Major.NURS, 2020),
				new Student("Peter", "Bobrov", Major.ECON, 2018));

		for (Student st : students) {
			JPanel studentPanel = new StudentPanel(st);
			mainPanelRows.add(studentPanel);
		}

		return mainPanelRows;
	}

}
