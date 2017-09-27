package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import tansinjahan.tdd.assignment.Course;

public class CourseTest {
	
	Course course = null;
	
	@Before
	public void setup() {
		course = new Course(
				true, // enforceprereq
				1, // mid
				2, // assign
				true, // hasFinal
				30, // capsize
				"Object Oriented Programming", // courseTitle
				113004 // courseCode
			);  
	}
	
	@Test
	public void courseTitleTest() {
		String getTitle = course.title();
		assertEquals("Object Oriented Programming", getTitle);
	}

}
