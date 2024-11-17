package app.model;

import static org.junit.jupiter.api.Assertions.*;

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
	void student_constructor_should_initialize_all_fields() {
		assertNotNull(student, "Student object should not be null");
		assertEquals(101014, student.getStudentId(), "Student ID should be 101014");
		assertEquals("John", student.getFirstName(), "First name should be 'John'");
		assertEquals("Doe", student.getLastName(), "Last name should be 'Doe'");
		assertEquals(Major.CSIS, student.getMajor(), "Major should be 'CSIS'");
		assertEquals(2023, student.getYear(), "Year should be 2023");
	}

	@Test
	void student_id_values_should_be_unique() {
		Student otherStudent = new Student("Jane", "Smith", Major.BIOL, 2024);
		assertEquals(101015, otherStudent.getStudentId(), "Other student ID should be 101015");
		assertNotEquals(student.getStudentId(), otherStudent.getStudentId());
	}

	@Test
	void student_id_values_should_increment_by_one() {
		Student otherStudent = new Student("Alice", "Johnson", Major.ENGR, 2023);
		assertTrue(otherStudent.getStudentId() > student.getStudentId(),
				"Subsequent student ID should be greater than the first");
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
