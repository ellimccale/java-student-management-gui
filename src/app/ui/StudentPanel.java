package app.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.model.Student;

/**
 * Represents a panel displaying information about a student.
 * <p>
 * This class extends {@link JPanel} and displays the student's ID, name (last
 * name, first name), major, and the year they started, organized in a single
 * row layout.
 * <p>
 * Uses a {@link GridLayout} to arrange components and is intended to be added
 * to its parent container {@link MainScrollPane}.
 * 
 * @author Aidan Reed
 * @author Elli Steck
 * @see app.model.Student
 */
public class StudentPanel extends JPanel {

	private static final long serialVersionUID = 4313955522649481600L;
	private Student student;

	public StudentPanel(Student student) {
		this.student = student;

		setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblStudentId = new JLabel("S" + this.student.getStudentId());
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStudentId);

		JLabel lblStudentLastFirst = new JLabel(this.student.toString());
		add(lblStudentLastFirst);

		JLabel lblStudentMajor = new JLabel(this.student.getMajor().toString());
		add(lblStudentMajor);

		JLabel lblStudentYear = new JLabel(Integer.toString(this.student.getYear()));
		lblStudentYear.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStudentYear);
	}

}
