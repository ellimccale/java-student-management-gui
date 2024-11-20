package app.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.model.Student;

/**
 * Represents a panel displaying information about a student.
 * <p>
 * The panel displays the student's ID, name (last name, first name), major, and
 * the year they started, organized in a single row layout.
 * </p>
 * 
 * <p>
 * This panel uses a {@link GridLayout} to arrange its components and is
 * intended to be added to a parent container such as a {@code JScrollPane}.
 * </p>
 * 
 * @author Aidan Reed
 * @author Elli Steck
 * @see app.model.Student
 */
public class StudentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Student student;

	public StudentPanel(Student student) {
		this.student = student;

		this.setLayout(new GridLayout(1, 0, 0, 0));

		// Create and add components for student details
		JLabel lblStudentId = new JLabel("S" + this.student.getStudentId());
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(lblStudentId);

		JLabel lblStudentLastFirst = new JLabel(this.student.toString());
		this.add(lblStudentLastFirst);

		JLabel lblStudentMajor = new JLabel(this.student.getMajor().toString());
		this.add(lblStudentMajor);

		JLabel lblStudentYear = new JLabel(Integer.toString(this.student.getYear()));
		lblStudentYear.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(lblStudentYear);
	}

}
