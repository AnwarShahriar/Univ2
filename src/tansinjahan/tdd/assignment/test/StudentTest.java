package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.CourseInteractor;
import tansinjahan.tdd.assignment.Student;
import tansinjahan.tdd.assignment.StudentTable;
import tansinjahan.tdd.assignment.University;

public class StudentTest {
	private static University versity;
	
	@BeforeClass
	public static void setup() {
		versity = University.getInstance();
	}
	
	@Before
		public void prepare() {
			StudentTable.getInstance().clear();
		}
	
	@Test
	public void createStudentIDTest(){
		Student student = versity.createStudent("Tansin", 1104, "full time");
		assertEquals(1104,student.getStudentNumber());
	}
	
	@Test
	public void createStudentNameTest(){
		Student student = versity.createStudent("Tansin", 1104, "full time");
		assertEquals("Tansin",student.getName());
	}
	
	@Test
		public void studentRegistersCourse() {
			Student student = versity.createStudent("John Doe", 123,"part time");
			CourseInteractor interactor = new CourseInteractor(versity);
			Course course = interactor.createCourse("cleark", "CS101", 101000, 27, true, 2, 1, false,true);
			student.registerCourse(course);
			
			List<Course> courses = student.currentCourses();
					
			boolean exist = false;
				for (Course c : courses) {
						if (c.getCode() == course.getCode()) {
							exist = true;
							break;
						}
					}
				assertEquals(true, exist);
		}
}
