package app.model;

import java.util.Objects;

/**
 * Represents a student with a unique ID, name, major, and starting year.
 * 
 * @author Elli Steck
 */
public class Student {

	private static int uuid;
	private final int studentId;
	private String firstName;
	private String lastName;
	private Major major;
	private int year;

	/**
	 * Public constructor for creating a new {@link Student} with the given details.
	 * Automatically generates a unique student ID using the internal {@code uuid}.
	 * <p>
	 * This constructor is intended for dynamically creating new students during
	 * runtime. For creating students from existing stored data, use the
	 * package-private constructor.
	 *
	 * @param firstName the student's first name
	 * @param lastName  the student's last name
	 * @param major     the student's major
	 * @param year      the year the student started
	 */
	public Student(String firstName, String lastName, Major major, int year) {
		this(uuid, firstName, lastName, major, year);
		uuid++;
	}

	/**
	 * Package-private constructor for creating a {@code Student} object using
	 * existing stored data from the CSV file. This constructor does not generate a
	 * new student ID and directly assigns the provided {@code studentId}.
	 * <p>
	 * Intended for use by classes within the same package, such as utility classes
	 * handling data loading. For dynamically creating new students, use the public
	 * constructor that generates a unique student ID.
	 * 
	 * @param studentId the student's unique identifier
	 * @param firstName the student's first name
	 * @param lastName  the student's last name
	 * @param major     the student's major
	 * @param year      the year the student started
	 * @see StudentManager
	 */
	Student(int studentId, String firstName, String lastName, Major major, int year) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.year = year;
	}

	/**
	 * Resets the static UUID. Package-private to restrict access to methods within
	 * the same package.
	 *
	 * @param value the value to replace the UUID
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
	 * Computes the hash code for this {@code Student} object.
	 * <p>
	 * The hash code is based solely on the {@code studentId}, ensuring that two
	 * {@code Student} objects with the same {@code studentId} will have the same
	 * hash code.
	 * 
	 * @return the hash code for this {@code Student} object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	/**
	 * Compares this {@code Student} to the specified object for equality.
	 * <p>
	 * Two {@code Student} objects are considered equal if and only if their
	 * {@code studentId} values are the same.
	 * 
	 * @param obj the object to compare this {@code Student} against
	 * @return {@code true} if the specified object is a {@code Student} with the
	 *         same {@code studentId}, {@code false} otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Student))
			return false;

		Student other = (Student) obj;
		return studentId == other.studentId;
	}

	/**
	 * Returns a string representation of the student in the format
	 * {@code lastName}, {@code firstName}
	 *
	 * @return a string containing the student's full name
	 */
	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}

}
