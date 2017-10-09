package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tansinjahan.tdd.assignment.University;

public class UniversityTest {

	@Test
	public void testName() {
		University versity = new University();
		assertEquals("Carleton", versity.getName());
	}
	
}