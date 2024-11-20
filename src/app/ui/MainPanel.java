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

public class MainPanel extends JScrollPane {

	private static final long serialVersionUID = 1L;

	public MainPanel() {
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll pane header

		JPanel mainPanelHeader = createMainPanelHeader();
		this.setColumnHeaderView(mainPanelHeader);

		// Scroll pane viewport

		JPanel mainPanelRows = createMainPanelRows();
		this.setViewportView(mainPanelRows);
	}

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

	private JPanel createMainPanelRows() {
		JPanel mainPanelRows = new JPanel();
		mainPanelRows.setLayout(new GridLayout(0, 1, 0, 0));

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
