package app.ui;

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
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel panelScrollHeader = createPanelScrollHeader();
		this.setColumnHeaderView(panelScrollHeader);

		JPanel panelScrollViewport = createPanelScrollViewport();
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
		lblLastFirstName.setPreferredSize(new Dimension(200, 20));
		gbc.gridx = 0;
		gbc.weightx = 0.5;
		panelScrollHeader.add(lblLastFirstName, gbc);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblStudentId.setPreferredSize(new Dimension(125, 20));
		gbc.gridx = 1;
		gbc.weightx = 0.0;
		panelScrollHeader.add(lblStudentId, gbc);

		JLabel lblAcademicYear = new JLabel("Academic year");
		lblAcademicYear.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblAcademicYear.setPreferredSize(new Dimension(125, 20));
		gbc.gridx = 2;
		panelScrollHeader.add(lblAcademicYear, gbc);

		JLabel lblMajor = new JLabel("Major");
		lblMajor.setFont(lblLastFirstName.getFont().deriveFont(Font.BOLD));
		lblMajor.setPreferredSize(new Dimension(200, 20));
		gbc.gridx = 3;
		gbc.weightx = 0.5;
		panelScrollHeader.add(lblMajor, gbc);

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
		panelScrollViewport.setLayout(new GridLayout(0, 1));

		try {
			Set<Student> students = StudentManager.getStudents();

			if (students.isEmpty()) {
				JLabel lblNoStudents = new JLabel("No students were found.");
				lblNoStudents.setHorizontalAlignment(SwingConstants.CENTER);
				panelScrollViewport.add(lblNoStudents);
			} else {
				int index = 0;
				for (Student student : students) {
					JPanel panelThisStudent = new StudentPanel(student);
					if (index % 2 == 0) {
						panelThisStudent.setBackground(new Color(220, 220, 220));
					}
					panelScrollViewport.add(panelThisStudent);
					index++;
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
