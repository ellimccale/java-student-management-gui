package app.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.model.Student;

public class StudentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Student student;

	public StudentPanel(Student student) {
		this.student = student;

		this.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblStudentLastFirst = new JLabel(this.student.toString());
		this.add(lblStudentLastFirst);

		JLabel lblStudentId = new JLabel(this.student.getStudentId());
		this.add(lblStudentId);

		JLabel lblStudentYear = new JLabel(Integer.toString(this.student.getYear()));
		this.add(lblStudentYear);

		JLabel lblStudentMajor = new JLabel(this.student.getMajor().toString());
		this.add(lblStudentMajor);
	}

}
