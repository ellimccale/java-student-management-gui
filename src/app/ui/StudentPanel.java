package app.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.model.Student;

/**
 * Represents a panel displaying information about a student.
 * <p>
 * This class extends {@link JPanel} and displays the student's ID, name (last
 * name, first name), major, and the year they started, organized in a single
 * row layout.
 * <p>
 * Uses a {@link GridBagLayout} to arrange components and is intended to be
 * added to its parent container {@link MainScrollPane}.
 * 
 * @author Elli Steck
 * @see app.model.Student
 */
public class StudentPanel extends JPanel {

	private static final long serialVersionUID = 4313955522649481600L;
	private final Student student;

	public StudentPanel(Student student) {
		this.student = student;

		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy = 0;

		JLabel lblStudentLastFirst = new JLabel(this.student.toString());
		lblStudentLastFirst.setPreferredSize(new Dimension(200, 40));
		gbc.gridx = 0;
		gbc.weightx = 0.5;
		this.add(lblStudentLastFirst, gbc);

		JLabel lblStudentId = new JLabel("S" + this.student.getStudentId());
		lblStudentId.setPreferredSize(new Dimension(125, 40));
		gbc.gridx = 1;
		gbc.weightx = 0.0;
		this.add(lblStudentId, gbc);

		JLabel lblStudentYear = new JLabel(Integer.toString(this.student.getYear()));
		lblStudentYear.setPreferredSize(new Dimension(125, 40));
		gbc.gridx = 2;
		this.add(lblStudentYear, gbc);

		JLabel lblStudentMajor = new JLabel(this.student.getMajor().toString());
		lblStudentMajor.setPreferredSize(new Dimension(200, 40));
		gbc.gridx = 3;
		gbc.weightx = 0.5;
		this.add(lblStudentMajor, gbc);
	}

}
