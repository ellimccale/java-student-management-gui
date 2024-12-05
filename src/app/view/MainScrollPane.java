package app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
 * @author Elli Steck
 * @see app.view.StudentPanel
 * @see app.model.Student
 * @see app.model.StudentManager
 */
public class MainScrollPane extends JScrollPane {

	private static final long serialVersionUID = 8079487866761426457L;
	private static final int LABEL_HEIGHT = 20;
	private JPanel panelScrollViewport;

	/**
	 * Constructs a new {@link MainScrollPane}, initializing the header and viewport
	 * with student information.
	 * <p>
	 * Horizontal scrolling is disabled to maintain a clean layout.
	 */
	public MainScrollPane() {
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel panelScrollHeader = createPanelScrollHeader();
		this.setColumnHeaderView(panelScrollHeader);

		panelScrollViewport = new JPanel(new GridLayout(0, 1));
		populatePanelScrollViewport();
		this.setViewportView(panelScrollViewport);
	}

	/**
	 * Creates the header row for the scroll pane, displaying column labels.
	 * 
	 * @return a {@link JPanel} containing the column header labels
	 */
	private JPanel createPanelScrollHeader() {
		JPanel panelScrollHeader = new JPanel();
		panelScrollHeader.setLayout(new GridBagLayout());
		panelScrollHeader.setBackground(new Color(200, 200, 200));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy = 0;

		JLabel lblLastFirstName = new JLabel("Name");
		lblLastFirstName.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblLastFirstName.setPreferredSize(new Dimension(200, LABEL_HEIGHT));
		gbc.gridx = 0;
		gbc.weightx = 0.5;
		panelScrollHeader.add(lblLastFirstName, gbc);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblStudentId.setPreferredSize(new Dimension(125, LABEL_HEIGHT));
		gbc.gridx = 1;
		gbc.weightx = 0.0;
		panelScrollHeader.add(lblStudentId, gbc);

		JLabel lblAcademicYear = new JLabel("Academic year");
		lblAcademicYear.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblAcademicYear.setPreferredSize(new Dimension(125, LABEL_HEIGHT));
		gbc.gridx = 2;
		panelScrollHeader.add(lblAcademicYear, gbc);

		JLabel lblMajor = new JLabel("Major");
		lblMajor.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblMajor.setPreferredSize(new Dimension(200, LABEL_HEIGHT));
		gbc.gridx = 3;
		gbc.weightx = 0.5;
		panelScrollHeader.add(lblMajor, gbc);

		return panelScrollHeader;
	}

	/**
	 * Populates the scrollable list of student rows, with each row represented by a
	 * {@link StudentPanel}.
	 * <p>
	 * If an error occurs while loading the students, the panel will display an
	 * error message instead of student rows.
	 * 
	 * @return a {@link JPanel} containing a vertical list of {@link StudentPanel}
	 *         objects or an error message
	 */
	private void populatePanelScrollViewport() {
		try {
			Set<Student> students = StudentManager.getStudents();

			if (students.isEmpty()) {
				JLabel lblNoStudents = new JLabel("No students were found.");
				lblNoStudents.setHorizontalAlignment(SwingConstants.CENTER);
				panelScrollViewport.add(lblNoStudents);
			} else {
				int index = 0;
				for (Student student : students) {
					addStudentPanel(student, index);
					index++;
				}
			}
		} catch (IOException e) {
			JLabel lblErrorLoading = new JLabel("Error loading students: " + e.getMessage());
			lblErrorLoading.setHorizontalAlignment(SwingConstants.CENTER);
			panelScrollViewport.add(lblErrorLoading);
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new {@link StudentPanel} for the given {@link Student} to the
	 * viewport.
	 * <p>
	 * This method dynamically inserts a new panel at the end of the viewport's list
	 * of student panels.
	 * 
	 * @param student the {@link Student} to be represented by the new panel
	 */
	public void addStudentPanel(Student student) {
		int currentIndex = panelScrollViewport.getComponentCount();
		addStudentPanel(student, currentIndex);
		panelScrollViewport.revalidate();
		panelScrollViewport.repaint();
	}

	/**
	 * Creates and adds a {@link StudentPanel} for the given {@link Student} at the
	 * specified index.
	 * <p>
	 * The panel is added to the viewport but does not trigger revalidation or
	 * repainting.
	 * 
	 * @param student the {@link Student} to be displayed in the panel
	 * @param index   the index at which the panel is added
	 */
	private void addStudentPanel(Student student, int index) {
		JPanel studentPanel = new StudentPanel(student);
		if (index % 2 == 0)
			studentPanel.setBackground(new Color(220, 220, 220));
		panelScrollViewport.add(studentPanel);
	}

}
