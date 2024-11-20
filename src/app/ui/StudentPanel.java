package app.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.model.Student;
import javax.swing.SwingConstants;

public class StudentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Student student;

	public StudentPanel(Student student) {
		this.student = student;

		this.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblStudentId = new JLabel("S" + this.student.getStudentId());
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(lblStudentId);

		JLabel lblStudentLastFirst = new JLabel(this.student.toString());
		this.add(lblStudentLastFirst);

		JLabel lblStudentMajor = new JLabel(" " + this.student.getMajor());
		this.add(lblStudentMajor);

		JLabel lblStudentYear = new JLabel(Integer.toString(this.student.getYear()));
		lblStudentYear.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(lblStudentYear);
	}

}
