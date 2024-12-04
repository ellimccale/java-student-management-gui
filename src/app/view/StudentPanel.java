package app.view;

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
	private static final int LABEL_HEIGHT = 40;
	private final Student student;

	/**
	 * Constructs a new {@code StudentPanel} to display a single student's
	 * information.
	 * 
	 * @param student the {@link Student} whose details will be displayed
	 */
	public StudentPanel(Student student) {
		this.student = student;

		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy = 0;

		addLabel(gbc, 0, 0.5, this.student.toString(), 200);
		addLabel(gbc, 1, 0.0, "S" + this.student.getStudentId(), 125);
		addLabel(gbc, 2, 0.0, Integer.toString(this.student.getYear()), 125);
		addLabel(gbc, 3, 0.5, this.student.getMajor().toString(), 200);
	}

	/**
	 * Helper method to create and add a {@link JLabel} to this panel.
	 * 
	 * @param gbc     the {@link GridBagConstraints} to configure the label's layout
	 * @param gridX   the column index for the label
	 * @param weightX the relative width of the column for the label
	 * @param text    the text to display in the label
	 * @param width   the preferred width for the label
	 */
	private void addLabel(
			GridBagConstraints gbc, int gridX, double weightX, String text, int width) {
		JLabel label = new JLabel(text);
		label.setPreferredSize(new Dimension(width, LABEL_HEIGHT));
		gbc.gridx = gridX;
		gbc.weightx = weightX;
		this.add(label, gbc);
	}

}
