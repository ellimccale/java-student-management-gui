package app.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MajorTest {

	@Test
	void major_to_string_should_return_correct_display_friendly_name() {
		assertEquals("Accounting", Major.ACCN.toString(), "toString for ACCN failed");
		assertEquals("Biotechnology", Major.BIOT.toString(), "toString for BIOT failed");
		assertEquals("Computer Science and Information Systems", Major.CSIS.toString(), "toString for CSIS failed");
	}

	@Test
	void major_valueOf_should_map_strings_to_constants() {
		assertEquals(Major.ACCN, Major.valueOf("ACCN"), "valueOf for ACCN failed");
		assertEquals(Major.BIOT, Major.valueOf("BIOT"), "valueOf for BIOT failed");
		assertEquals(Major.CSIS, Major.valueOf("CSIS"), "valueOf for CSIS failed");
	}

	@Test
	void major_should_have_correct_number_of_constants() {
		Major[] majors = Major.values();
		assertEquals(52, majors.length, "Number of Major constants is incorrect");
	}

	@Test
	void major_invalid_valueOf_should_throw_illegal_argument_exception() {
		assertThrows(IllegalArgumentException.class, () -> Major.valueOf("INVALID"),
				"Invalid value should throw exception");
	}

}
