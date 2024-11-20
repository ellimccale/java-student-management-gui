package app.model;

/**
 * Represents a student with a unique ID, name, major, and starting year.
 * 
 * @author Aidan Reed
 * @author Elli Steck
 */
public class Student {

	private static int uuid = 101014;
	private int studentId;
	private String firstName;
	private String lastName;
	private Major major;
	private int year;

	/**
	 * Constructs a new Student with the given details. Automatically generates a
	 * unique student ID.
	 *
	 * @param firstName the student's first name
	 * @param lastName  the student's last name
	 * @param major     the student's major
	 * @param year      the year the student started
	 */
	public Student(String firstName, String lastName, Major major, int year) {
		generateId();

		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.year = year;
	}

	/**
	 * Generates a unique student ID for the student.
	 */
	private final void generateId() {
		this.studentId = uuid;
		uuid++;
	}

	/**
	 * Resets the static UUID for testing purposes. Package-private to restrict
	 * access to tests within the same package.
	 *
	 * @param value the value to reset the UUID to
	 */
	static void resetUuid(int value) {
		uuid = value;
	}

	/**
	 * Gets the student's unique ID.
	 *
	 * @return the student's ID
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * Gets the student's first name.
	 *
	 * @return the student's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the student's first name.
	 *
	 * @param firstName the student's new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the student's last name.
	 *
	 * @return the student's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the student's last name.
	 *
	 * @param lastName the student's new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the student's major.
	 *
	 * @return the student's major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * Sets the student's major.
	 *
	 * @param major the student's new major
	 */
	public void setMajor(Major major) {
		this.major = major;
	}

	/**
	 * Gets the year the student started.
	 *
	 * @return the year the student started
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year the student started.
	 *
	 * @param year the student's new starting year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns a string representation of the student in the format
	 * {lastName}, {firstName}
	 *
	 * @return a string containing the student's last name, followed by a comma and
	 *         a space, and then the student's first name
	 */
	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}

}
