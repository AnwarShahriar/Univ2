package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.CourseInteractor;
import tansinjahan.tdd.assignment.CourseTable;
import tansinjahan.tdd.assignment.Student;
import tansinjahan.tdd.assignment.StudentTable;
import tansinjahan.tdd.assignment.University;
import tansinjahan.tdd.assignment.test.TestTermSimulator;

public class StudentTest {
	private static University versity;
	private TestTermSimulator simulator;
	
		@BeforeClass
		public static void setup() {
		versity = University.getInstance();
	}
	
		@Before
		public void prepare() {
			simulator = new TestTermSimulator(versity);
			simulator.termCreated();
			
			StudentTable.getInstance().clear();
			CourseTable.getInstance().clear();
					
			prepareDummyCourse();
		}
	
		@Test
		public void studentRegistersForACourseDoesNotThrowException() {
			simulator.termAllowCourseRegistration();
			Student student = new Student("John", 23,"Full time");
			Course course = CourseTable.getInstance().findCourseByCode(111110);
			student.selectCourse(course);
			versity.registerStudentForCourse(student, course);
		}
	
		private void prepareDummyCourse() {
				CourseInteractor courseInteractor = new CourseInteractor(versity);
				CourseTable.getInstance().add(courseInteractor.createCourse("cleark", "CS101", 111110, 26, true, 2, 1, false, false));
				CourseTable.getInstance().add(courseInteractor.createCourse("cleark", "CS102", 111111, 26, true, 2, 1, false, false));
				CourseTable.getInstance().add(courseInteractor.createCourse("cleark", "CS103", 111112, 26, true, 2, 1, false, false));
				CourseTable.getInstance().add(courseInteractor.createCourse("cleark", "CS104", 111113, 26, true, 2, 1, false, false));
				CourseTable.getInstance().add(courseInteractor.createCourse("cleark", "CS105", 111114, 26, true, 2, 1, false, true));
		}
	
		@Test(expected = IllegalStateException.class)
		public void duplicateCourseRegistrationThrowsException() {
			simulator.termAllowCourseRegistration();
			Student student = new Student("John", 23,"full time");
			Course course = CourseTable.getInstance().findCourseByCode(111110);
			
			student.selectCourse(course);
			versity.registerStudentForCourse(student, course);
			versity.registerStudentForCourse(student, course);
		}
	
		@Test(expected = IllegalStateException.class)
		public void courseRegistrationAttemptMoreThan4ThrowsExceptionForFullTimeStudent() {
			Student student = new Student("John", 23,"Full time");
			Course course1 = CourseTable.getInstance().findCourseByCode(111110);
			Course course2 = CourseTable.getInstance().findCourseByCode(111111);
			Course course3 = CourseTable.getInstance().findCourseByCode(111112);
			Course course4 = CourseTable.getInstance().findCourseByCode(111113);
			Course course5 = CourseTable.getInstance().findCourseByCode(111114);
			
			versity.registerStudentForCourse(student, course1);
			versity.registerStudentForCourse(student, course2);
			versity.registerStudentForCourse(student, course3);
			versity.registerStudentForCourse(student, course4);
			versity.registerStudentForCourse(student, course5);
		}
	
		@Test(expected = IllegalStateException.class)
		public void courseRegistrationAttemptMoreThan2ThrowsExceptionForPartTimeStudent() {
			Student student = new Student("John", 23,"Part time");
			
			Course course1 = CourseTable.getInstance().findCourseByCode(111110);
			Course course2 = CourseTable.getInstance().findCourseByCode(111111);
			Course course3 = CourseTable.getInstance().findCourseByCode(111112);
			
			versity.registerStudentForCourse(student, course1);
			versity.registerStudentForCourse(student, course2);
			versity.registerStudentForCourse(student, course3);
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
			Course course = interactor.createCourse("clerk", "CS101", 101000, 27, true, 2, 1, false,true);
			student.selectCourse(course);
			student.registerCourse(course);
			
			List<Course> courses = student.currentCourses();
			
			assertEquals(course.getCode(), courses.get(0).getCode());
		}
	
		@Test
	 	public void studentWithSameStudentNumberHasSameHashCode() {
	 		Student student1 = new Student("John", 23,"Full time");
	 		Student student2 = new Student("John", 23,"Full time");
	 		assertEquals(student1.hashCode(), student2.hashCode());
	 	}
	
		@Test
	 	public void studentHasCompletedCourses() {
	 		Student student = new Student("John", 23,"Part Time");
	 		Course c1 = CourseTable.getInstance().findCourseByCode(111110);
	 		Course c2 = CourseTable.getInstance().findCourseByCode(111111);
	 		
	 		student.selectCourse(c1);
	 		student.selectCourse(c2);
	 		
	 		student.registerCourse(c1);
	 		student.registerCourse(c2);
	 		
	 		student.completedCourse(c1);
	 		student.completedCourse(c2);
	 		
	 		assertEquals(2, student.completedCourses().size());
	 	}
	
		@Test(expected = IllegalArgumentException.class)
	 	public void attemptsToCompleteCourseNotInRegisteredCourseListThrowsException() {
	 		Student student = new Student("John", 23,"Part time");
	 		Course c1 = CourseTable.getInstance().findCourseByCode(111110);
	 		Course c2 = CourseTable.getInstance().findCourseByCode(111111);
	 		
	 		student.selectCourse(c1);
	 		student.selectCourse(c2);
	 		
	 		student.registerCourse(c1);
	 		student.completedCourse(c2);
	 	}
	
		@Test
	 	public void selectCourseSucceed() {
	 		Student student = new Student("John", 23,"Part time");
	 		Course c1 = CourseTable.getInstance().findCourseByCode(111110);
	 		Course c2 = CourseTable.getInstance().findCourseByCode(111111);
	 		
	 		student.selectCourse(c1);
	 		student.selectCourse(c2);
	 		
	 		assertEquals(2, student.selectedCourses().size());
	 	}
	 	
	 	@Test(expected = IllegalArgumentException.class)
	 	public void attemptsToSelectAlreadyRegisteredCourseThrowsException() {
	 		Student student = new Student("John", 23,"Full time");
	 		Course c = CourseTable.getInstance().findCourseByCode(111110);
	 		student.selectCourse(c);
	 		student.registerCourse(c);
	 		student.selectCourse(c);
	 	}
	 	
	 	@Test(expected = IllegalArgumentException.class)
	 	public void attemptsToSelectAlreadyCompletedCourseThrowsException() {
	 		Student student = new Student("John", 23,"Full Time");
	 		Course c = CourseTable.getInstance().findCourseByCode(111110);
	 		student.selectCourse(c);
	 		student.registerCourse(c);
	 		student.completedCourse(c);
	 		student.selectCourse(c);
	 	}
	 	
	 	@Test(expected = IllegalStateException.class)
	 	public void attemptsToRegisterCourseNotInSelectedCoursesThrowsException() {
	 		Student student = new Student("John", 23,"Part Time");
	 		Course c = CourseTable.getInstance().findCourseByCode(111110);
	 		student.registerCourse(c);
	 	}
	 	
	 	@Test
	 	public void studentDropsCourse() {
	 	 		Student student = new Student("John", 23,"Full time");
	 	 		Course c = CourseTable.getInstance().findCourseByCode(111110);
	 	 		student.selectCourse(c);
	 	 		student.registerCourse(c);
	 	 		assertEquals(true, student.dropCourse(c));
	 	 	}
	 	 	
	 	 @Test
	 	 public void studentCannotDropUnregisteredCourses() {
	 	 		Student student = new Student("John", 23,"Full time");
	 	 		Course c = CourseTable.getInstance().findCourseByCode(111110);
	 	 		student.selectCourse(c);
	 	 		assertEquals(false, student.dropCourse(c));
	 	 	}
	 	 	
	 	 @Test
	 	 public void studentDeregisterCourse() {
	 	 		Student student = new Student("John", 23,"Part Time");
	 	 		Course c = CourseTable.getInstance().findCourseByCode(111110);
	 	 		student.selectCourse(c);
	 	 		student.registerCourse(c);
	 	 		assertEquals(true, student.deRegisterCourse(c));
	 	 	}
	
}
