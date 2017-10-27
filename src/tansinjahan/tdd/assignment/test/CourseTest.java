package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.CourseInteractor;
import tansinjahan.tdd.assignment.ProjectCourse;
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
	 								true, // enforcePrereqs)
	 								true //isProjectCourse
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
	 								true, // enforcePrereqs)
	 								true //isProjectCourse
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
 								true, // enforcePrereqs)
 								true //isProjectCourse
 								);
	}
	
	@Test(expected = IllegalArgumentException.class)
		public void invalidCourseAssignmentThrowsException() {
		interactor.createCourse(
								"clerk", // user
								"CS", // title,
								110022, // code
								26, // capsize
								false, // hasAFinal
								6, // numberOfAssignments,
								0, // numberOfMidterms,
								true, // enforcePrereqs)
								true //isProjectCourse
								);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidCourseMidThrowsException() {
	interactor.createCourse(
							"clerk", // user
							"CS", // title,
							110022, // code
							26, // capsize
							false, // hasAFinal
							2, // numberOfAssignments,
							3, // numberOfMidterms,
							true, // enforcePrereqs)
							true  //isProjectCourse
							);

	}
	
	@Test
		public void courseHasProject() {
			ProjectCourse course = (ProjectCourse) interactor.createCourse(
									"clerk", // user
									"CS", // title,
									110022, // code
									26, // capsize
									false, // hasAFinal
									1, // numberOfAssignments,
									0, // numberOfMidterms,
									true, // enforcePrereqs)
									true // isProjectCourse
									);
			assertEquals(true, course.hasProject());
		}
	
	@Test
		public void totalWeightOfGradeElemsEqualsTo100() {
			Course course = null;
			course = interactor.createCourse(
										"clerk", // user
										"CS", // title,
										110022, // code
										26, // capsize
										true, // hasAFinal
										2, // numberOfAssignments,
										2, // numberOfMidterms,
										true, // enforcePrereqs)
										false // isProjectCourse
										);
			int totalWeight = 0;
			for (int i = 1; i <= 2; i++) {
				totalWeight += course.weightOfAssignment(i);
			}
			for (int i = 1; i <= 2; i++) {
				totalWeight += course.weightOfMidterm(i);
			}
			totalWeight += course.weightOfFinal();
			
			assertEquals(100, totalWeight);
		}
	
	@Test
		public void totalWeightOfGradeElemsInProjectCourseEqualsTo100() {
			ProjectCourse course = null;
			course = (ProjectCourse) interactor.createCourse(
										"clerk", // user
										"CS", // title,
										110022, // code
										26, // capsize
										true, // hasAFinal
										2, // numberOfAssignments,
										2, // numberOfMidterms,
										true, // enforcePrereqs)
										true // isProjectCourse
										);
			int totalWeight = 0;
			for (int i = 1; i <= 2; i++) {
				totalWeight += course.weightOfAssignment(i);
			}
			for (int i = 1; i <= 2; i++) {
				totalWeight += course.weightOfMidterm(i);
			}
			totalWeight += course.weightOfFinal();
			totalWeight += course.weightOfProject();
			
			assertEquals(100, totalWeight);
		}
	
	@Test
	 	public void addStudentSucceed() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		boolean success = course.addStudent(new Student("John", 123,"Part Time"));
	 		assertEquals(true, success);
	 	}
	
	@Test
	 	public void duplicateAddStudentFails() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		course.addStudent(new Student("John", 123,"Part Time"));
	 		boolean failure = course.addStudent(new Student("John", 123,"Part Time"));
	 		assertEquals(false, failure);
	 	}
	
	@Test
	 	public void addStudentFailsWhenExceedsCapSize() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		for(int i = 0; i < 26; i++) {
	 			String name = "Student " + i;
	 			course.addStudent(new Student(name, i,"Full Time"));
	 		}
	 		
	 		String name = "Student 26";
	 		boolean failure = course.addStudent(new Student(name, 26,"Part Time"));
	 		assertEquals(false, failure);
	 	}
	
	@Test
	 	public void courseIsFullWhenStudentReachesCapSize() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		for(int i = 0; i < 26; i++) {
	 			String name = "Student " + i;
	 			course.addStudent(new Student(name, i,"Full time"));
	 		}
	 		assertEquals(true, course.isFull());
	 	}
	
	@Test
	 	public void removeStudentSucceedForRegisteredStudent() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		course.addStudent(new Student("John", 123,"Part Time"));
	 		boolean success = course.removeStudent(new Student("John", 123,"Part Time"));
	 		assertEquals(true, success);
	 	}
	
	@Test
	 	public void removeStudentFailsForNotRegisteredStudent() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		boolean failure = course.removeStudent(new Student("John", 123,"full time"));
	 		assertEquals(false, failure);
	 	}
	
	@Test
	 	public void courseHasproject() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									true // isProjectCourse
	 									);
	 		assertEquals(true, course.hasProject());
	 	}
	
	@Test
	 	public void courseHasNoProject() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		assertEquals(false, course.hasProject());
	 	}
	
	@Test
	 	public void courseHasStudents() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		course.addStudent(new Student("One", 1,"Full Time"));
	 		course.addStudent(new Student("Two", 2,"Part time"));
	 		course.addStudent(new Student("Three", 3,"Full Time"));
	 		
	 		assertEquals(3, course.students().size());
	 	}
	
	@Test
	 	public void courseMarksRequestedForRegisteredStudent() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		course.addStudent(new Student("One", 1,"Full time"));
	 		boolean markIsGreaterThanZero = course.markForStudent(new Student("One", 1,"Full time")) > 0;
	 		assertEquals(true, markIsGreaterThanZero);
	 	}
	
	@Test(expected = IllegalArgumentException.class)
	 	public void courseMarksRequestForNotRegisteredStudentThrowsException() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		course.markForStudent(new Student("One", 1,"Part Time"));
	 	}
	
	@Test
	 	public void alreadyRecordedStudentMarkIsSameAsBefore() {
	 		Course course = interactor.createCourse(
	 									"clerk", // user
	 									"CS", // title,
	 									110022, // code
	 									26, // capsize
	 									true, // hasAFinal
	 									2, // numberOfAssignments,
	 									2, // numberOfMidterms,
	 									true, // enforcePrereqs)
	 									false // isProjectCourse
	 									);
	 		course.addStudent(new Student("One", 1,"Full time"));
	 		
	 		int markForStudent = course.markForStudent(new Student("One", 1,"Full time"));
	 		int againMarkForStudent = course.markForStudent(new Student("One", 1,"Full Time"));
	 		
	 		assertEquals(true, markForStudent == againMarkForStudent);
	 	}
	
	@Test
	 	public void courseWithSameCourseIdIsEqual() {
	 		Course course1 = interactor.createCourse(
	 				"clerk", // user
	 				"CS", // title,
	 				110022, // code
	 				26, // capsize
	 				true, // hasAFinal
	 				2, // numberOfAssignments,
	 				2, // numberOfMidterms,
	 				true, // enforcePrereqs)
	 				false // isProjectCourse
	 				);
	 		
	 		Course course2 = interactor.createCourse(
	 				"clerk", // user
	 				"CS", // title,
	 				110022, // code
	 				26, // capsize
	 				true, // hasAFinal
	 				2, // numberOfAssignments,
	 				2, // numberOfMidterms,
	 				true, // enforcePrereqs)
	 				false // isProjectCourse
	 				);
	 		
	 		assertEquals(course1, course2);
	 	}
	
	@Test
	 	public void courseWithSameCourseIdHasSameHashCode() {
	 		Course course1 = interactor.createCourse(
	 				"clerk", // user
	 				"CS", // title,
	 				110022, // code
	 				26, // capsize
	 				true, // hasAFinal
	 				2, // numberOfAssignments,
	 				2, // numberOfMidterms,
	 				true, // enforcePrereqs)
	 				false // isProjectCourse
	 				);
	 		
	 		Course course2 = interactor.createCourse(
	 				"clerk", // user
	 				"CS", // title,
	 				110022, // code
	 				26, // capsize
	 				true, // hasAFinal
	 				2, // numberOfAssignments,
	 				2, // numberOfMidterms,
	 				true, // enforcePrereqs)
	 				false // isProjectCourse
	 				);
	 		
	 		assertEquals(course1.hashCode(), course2.hashCode());
	 	}
}
