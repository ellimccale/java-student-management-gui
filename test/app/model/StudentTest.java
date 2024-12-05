package app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {

	private Student student;

	@BeforeEach
	void setUp() {
		// Reset static UUID for consistent testing
		Student.resetUuid(101014);
		student = new Student("John", "Doe", Major.CSIS, 2023);
	}

	@Test
	void constructor_should_throw_exception_for_null_name_fields() {
		assertThrows(IllegalArgumentException.class,
				() -> new Student(null, "Last", Major.CSIS, 2023),
				"Constructor should throw exception for null first name");

		assertThrows(IllegalArgumentException.class,
				() -> new Student("First", null, Major.CSIS, 2023),
				"Constructor should throw exception for null last name");
	}

	@Test
	void constructor_should_throw_exception_for_invalid_academic_year() {
		int invalidYear = Year.now().getValue() - 11; // More than 10 years ago
		assertThrows(IllegalArgumentException.class,
				() -> new Student("Invalid", "Year", Major.CSIS, invalidYear),
				"Constructor should throw exception for an academic year more than 10 years ago");
	}

	@Test
	void public_constructor_should_initialize_all_fields() {
		assertNotNull(student, "Student object should not be null");
		assertEquals(101014, student.getStudentId(), "Student ID should be 101014");
		assertEquals("John", student.getFirstName(), "First name should be 'John'");
		assertEquals("Doe", student.getLastName(), "Last name should be 'Doe'");
		assertEquals(Major.CSIS, student.getMajor(), "Major should be 'CSIS'");
		assertEquals(2023, student.getYear(), "Year should be 2023");
	}

	@Test
	void package_private_constructor_should_initialize_all_fields_without_changing_uuid() {
		Student loadedStudent = new Student(101020, "Jane", "Smith", Major.BIOL, 2024);

		assertNotNull(loadedStudent, "Student object should not be null");
		assertEquals(101020, loadedStudent.getStudentId(), "Student ID should be 101020");
		assertEquals("Jane", loadedStudent.getFirstName(), "First name should be 'Jane'");
		assertEquals("Smith", loadedStudent.getLastName(), "Last name should be 'Smith'");
		assertEquals(Major.BIOL, loadedStudent.getMajor(), "Major should be 'BIOL'");
		assertEquals(2024, loadedStudent.getYear(), "Year should be 2024");

		assertEquals(101014, student.getStudentId(), "UUID should not be altered by package-private constructor");
	}

	@Test
	void studentId_values_should_be_unique() {
		Student otherStudent = new Student("Jane", "Smith", Major.BIOL, 2024);

		assertEquals(101015, otherStudent.getStudentId(), "Other student ID should be 101015");
		assertNotEquals(student.getStudentId(), otherStudent.getStudentId());
	}

	@Test
	void studentId_values_should_increment_by_one() {
		Student otherStudent = new Student("Alice", "Johnson", Major.ENGR, 2023);
		assertTrue(otherStudent.getStudentId() > student.getStudentId(),
				"Subsequent student ID should be greater than the first");
	}

	@Test
	void resetUuid_should_update_uuid_and_generate_ids_from_new_value() {
		Student.resetUuid(200001);
		Student newStudent = new Student("New", "Student", Major.CSIS, 2023);

		assertEquals(200001, newStudent.getStudentId(), "Student ID should start from the reset UUID value");
	}

	@Test
	void equals_should_return_true_for_same_student_id() {
		Student duplicateStudent = new Student(student.getStudentId(), "Duplicate", "Student", Major.CSIS, 2023);
		assertEquals(student, duplicateStudent, "Students with the same ID should be equal");
	}

	@Test
	void student_getters_should_return_appropriate_fields() {
		assertEquals(101014, student.getStudentId(), "Student ID getter failed");
		assertEquals("John", student.getFirstName(), "First name getter failed");
		assertEquals("Doe", student.getLastName(), "Last name getter failed");
		assertEquals(Major.CSIS, student.getMajor(), "Major getter failed");
		assertEquals(2023, student.getYear(), "Year getter failed");
	}

	@Test
	void students_setters_should_update_appropriate_fields() {
		student.setFirstName("Jane");
		student.setLastName("Smith");
		student.setMajor(Major.BIOL);
		student.setYear(2024);

		assertEquals("Jane", student.getFirstName(), "First name setter failed");
		assertEquals("Smith", student.getLastName(), "Last name setter failed");
		assertEquals(Major.BIOL, student.getMajor(), "Major setter failed");
		assertEquals(2024, student.getYear(), "Year setter failed");
	}

}
