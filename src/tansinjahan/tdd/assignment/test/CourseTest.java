package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.Student;

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
	@Test
	public void courseCodeTest(){
		assertEquals(113004,course.getCourseCode());
	}
	@Test
	public void courseHasZeroStudent(){
		assertEquals(0, course.getStudents().size());
	}
	@Test
	public void courseHasStudent(){
		course.addStudent(new Student());
		course.addStudent(new Student());
		assertEquals(2, course.getStudents().size());
	}
	@Test
	public void courseHasZeroPreRequisite(){
		assertEquals(0,course.prerequisitesOfCourse().size());
	}
	@Test
	public void courseHasPreRequisites(){
		course.addPrerequisite(113047);
		assertEquals(1,course.prerequisitesOfCourse().size());
	}
	@Test
	public void courseAssignmentWeight(){
		course.setWeightOfAssignment(1, 10);
		assertEquals(10,course.weightOfAssignment(1));
	}
	@Test
	public void courseMidtermWeight(){
		course.setWeightOfMidterm(1, 20);
		assertEquals(20,course.weightOfMidterms(1));
	}
	@Test
	public void courseFinalWeight(){
		course.setWeightOfFinal(50);
		assertEquals(50,course.weightOfFinal());
	}

}
