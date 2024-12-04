package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Manages the storage and retrieval of {@link Student} data.
 * <p>
 * Provides methods for reading and writing student records to a CSV file.
 * This class also handles ID management and prevents duplicate records.
 * <p>
 * This class maintains a private in-memory {@link Set} of {@link Student}
 * objects, which is lazily initialized and populated as needed.
 * 
 * @author Elli Steck
 * @see Student
 */
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
	 * Adds a new {@link Student} to the collection and saves the updated list to
	 * the data file.
	 * <p>
	 * Ensures the collection is loaded and checks for duplicates before adding the
	 * student. If the student already exists, it is not added, and a message is
	 * logged.
	 * 
	 * @param student the {@link Student} to add
	 * @throws IOException if an error occurs while saving the updated data to the
	 *                     CSV file
	 */
	public static void addStudent(Student student) throws IOException {
		if (students == null)
			loadStudentsFromFile();

		if (students.contains(student)) {
			System.err.println("Duplicate student detected: " + student);
			return;
		}

		students.add(student);
		saveStudentsToFile();
	}

	/**
	 * Loads student data from the CSV file into memory.
	 * <p>
	 * This method initializes the internal {@code students} set and populates it
	 * with {@link Student} objects created from the data in the CSV file.
	 * <p>
	 * The {@code uuid} for generating new student IDs is set to the highest
	 * existing student ID in the file plus one. If the file is empty or no valid
	 * IDs are found, the {@code uuid} defaults to {@code 101001}.
	 * 
	 * @throws IOException if an error occurs while reading the CSV file
	 */
	private static void loadStudentsFromFile() throws IOException {
		int maxId = 0;

		try (BufferedReader reader = new BufferedReader(
				new FileReader(STUDENT_DATA_FILE))) {
			students = new LinkedHashSet<>();
			String row;

			while ((row = reader.readLine()) != null) {
				if (row.trim().isEmpty())
					continue;

				Student student = createStudent(row);

				if (student instanceof Student) {
					students.add(student);
					maxId = Math.max(maxId, student.getStudentId());
				} else {
					System.err.println("Invalid student data: " + row);
				}
			}
		}

		Student.resetUuid(maxId == 0 ? 101001 : maxId + 1);
	}

	/**
	 * Parses a CSV row into a {@link Student} object.
	 * <p>
	 * Extracts student data from a comma-separated {@code String}, including the
	 * student ID, first name, last name, major, and academic year. If the row is
	 * invalid or contains insufficient or malformed data, an error is logged, and
	 * {@code null} is returned.
	 * 
	 * @param row a comma-separated {@code String} representing a student's data
	 * @return a {@link Student} object created from the row, or {@code null} if
	 *         parsing fails
	 */
	private static Student createStudent(String row) {
		String[] columns = row.split(",");

		try {
			if (columns.length < 5)
				throw new ArrayIndexOutOfBoundsException(
						"Insufficient columns in row: " + row);

			int studentId = Integer.parseInt(columns[0]);
			String firstName = columns[1];
			String lastName = columns[2];
			Major major = Major.valueOf(columns[3]);
			int academicYear = Integer.parseInt(columns[4]);

			return new Student(studentId, firstName, lastName, major, academicYear);
		} catch (NumberFormatException ex) {
			System.err.println(
					"Error parsing number in row: " + row + ". " + ex.getMessage());
			ex.printStackTrace();
		} catch (IllegalArgumentException ex) {
			System.err.println(
					"Invalid value for field in row: " + row + ". " + ex.getMessage());
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.err.println(
					"Row has insufficient data: " + row + ". " + ex.getMessage());
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Saves all students to the CSV file.
	 * <p>
	 * Iterates through the current {@link Student} collection and writes each
	 * student's data to the CSV file specified by {@code STUDENT_DATA_FILE}. The
	 * file is overwritten with the updated list of students. Each student's data is
	 * serialized in a comma-separated format.
	 * 
	 * @throws IOException if an error occurs while writing to the file
	 */
	private static void saveStudentsToFile() throws IOException {
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter(STUDENT_DATA_FILE))) {
			for (Student student : students) {
				writer.write(String.join(",",
						String.valueOf(student.getStudentId()),
						student.getFirstName(),
						student.getLastName(),
						student.getMajor().name(),
						String.valueOf(student.getYear())
				));
				writer.newLine();
			}
		}
	}

}
