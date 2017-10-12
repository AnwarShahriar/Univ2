package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.CourseInteractor;
import tansinjahan.tdd.assignment.Student;
import tansinjahan.tdd.assignment.University;

public class CourseTest {
	private static final Course NULL = null;
	private CourseInteractor interactor;

	private static University versity;
	
	@BeforeClass
	 	public static void setup() {
	 		versity = new University();
	 	}
	
	@Before
	 	public void prepare() {
	 		interactor = new CourseInteractor(versity);
	 	}
	@Test
	 	public void createCourse() {
	 	    interactor = new CourseInteractor(versity);
	 		Course course= NULL;
	 		try {
	 			course = interactor.createCourse(
	 								"clerk", // user
	 								"CS", // title,
	 								110022, // code
	 								26, // capsize
	 								true, // hasAFinal
	 								2, // numberOfAssignments,
	 								1, // numberOfMidterms,
	 								true // enforcePrereqs)
	 								);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		assertEquals(true, course != null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	 	public void invalidCourseIdThrowsException() {
	 		interactor.createCourse(
	 								"clerk", // user
	 								"CS", // title,
	 								010022, // code
	 								26, // capsize
	 								true, // hasAFinal
	 								2, // numberOfAssignments,
	 								1, // numberOfMidterms,
	 								true // enforcePrereqs)
	 								);
	}
	@Test(expected = IllegalArgumentException.class)
 		public void invalidCourseFinalThrowsException() {
 		interactor.createCourse(
 								"clerk", // user
 								"CS", // title,
 								110022, // code
 								26, // capsize
 								false, // hasAFinal
 								0, // numberOfAssignments,
 								0, // numberOfMidterms,
 								true // enforcePrereqs)
 								);
}

}
