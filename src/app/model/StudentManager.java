package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class StudentManager {

	private static final String STUDENT_DATA_FILE = "data/StudentData.csv";
	private static Set<Student> students = null;

	/**
	 * Retrieves all students from the CSV file.
	 * <p>
	 * If the students have not yet been loaded, this method calls
	 * {@link #loadStudentsFromFile()} to load them into memory. The returned set is
	 * unmodifiable to prevent external modification.
	 * 
	 * @return an unmodifiable set of {@link Student} objects
	 * @throws IOException if an error occurs while reading the CSV file
	 */
	public static Set<Student> getStudents() throws IOException {
		if (students == null)
			loadStudentsFromFile();

		return Collections.unmodifiableSet(students);
	}

	/**
	 * Loads student data from the CSV file into memory.
	 * <p>
	 * This method initializes the internal {@code students} set and populates it
	 * with {@link Student} objects created from the data in the CSV file. The first
	 * row of the CSV file (column headers) is skipped.
	 * <p>
	 * The {@code uuid} for generating new student IDs is set to the highest
	 * existing student ID in the file plus one. If the file is empty or no valid
	 * IDs are found, the {@code uuid} defaults to {@code 101001}.
	 * 
	 * @throws IOException if an error occurs while reading the CSV file
	 */
	private static void loadStudentsFromFile() throws IOException {
		int maxId = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_DATA_FILE))) {
			reader.readLine(); // Skip the column header row

			students = new LinkedHashSet<>();
			String row;

			while ((row = reader.readLine()) != null) {
				String[] columns = row.split(",");

				int studentId = Integer.parseInt(columns[0]);
				maxId = Math.max(maxId, studentId);

				students.add(new Student(
						studentId,                   // ID from the data file
						columns[1],                  // First name
						columns[2],                  // Last name
						Major.valueOf(columns[3]),   // Major
						Integer.parseInt(columns[4]) // Year
				));
			}
		}

		Student.resetUuid(maxId == 0 ? 101001 : maxId + 1);
	}

	@SuppressWarnings("unused")
	private static void saveStudentsToFile() throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_DATA_FILE))) {

		}
	}

}
