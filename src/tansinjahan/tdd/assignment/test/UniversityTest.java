package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tansinjahan.tdd.assignment.CourseInteractor;
import tansinjahan.tdd.assignment.CourseTable;
import tansinjahan.tdd.assignment.StudentTable;
import tansinjahan.tdd.assignment.University;
import tansinjahan.tdd.assignment.University.TermState;
import tansinjahan.tdd.assignment.TermEventListener;
import tansinjahan.tdd.assignment.TermSimulator;

public class UniversityTest {
	University versity;
	TestTermSimulator simulator;
	CourseInteractor interactor;
	
	@Before
	public void setup() {
		versity = University.getInstance();
		simulator = new TestTermSimulator(versity);
		interactor = new CourseInteractor(versity);
		CourseTable.getInstance().clear();
		StudentTable.getInstance().clear();
	}
	
	@Test
	public void termIsCreated() {
		simulator.termCreated();
		assertEquals(TermState.CREATE_STUDENT_COURSE_STATE, versity.getTermState());
	}
	
	@Test
	public void termIsReadyForRegistration() {
		simulator.termAllowCourseRegistration();
		assertEquals(TermState.COURSE_REGISTRATION_STATE, versity.getTermState());
	}
	
	@Test
	public void termStartedProperly() {
		simulator.startTerm();
		assertEquals(TermState.TERM_PROPERLY_STARTED_STATE, versity.getTermState());
	}
	
	@Test
	public void termEnded() {
		simulator.endTerm();
		assertEquals(TermState.TERM_END_STATE, versity.getTermState());
	}
	
	public class TestTermSimulator extends TermSimulator {

		public TestTermSimulator(TermEventListener listener) {
			super(listener);
		}

		public void endTerm() {
			listener.onTermEnded();
		}

		public void startTerm() {
			listener.onTermProperlyStarted();
		}

		public void termAllowCourseRegistration() {
			listener.onRegistrationPossible();
		}

		public void termCreated() {
			listener.onCreate();
		}
		
	}
	
		@Test
		public void testUniversityCourseCount() {
			versity.universityCourseCount(20);
			assertEquals(20, versity.getUniversityCourseCount());
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void universityCourseCountGreaterThan_25_ThrowsException() {
			versity.universityCourseCount(30);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void universityCourseCountSmallerThan_1_ThrowsException() {
			versity.universityCourseCount(0);
		}
		
		@Test
		public void testUniversityPassRate() {
			versity.passRate(65);
			assertEquals(65, versity.getPassRate());
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void universityPassRateGreaterThan_100_ThrowsException() {
			versity.passRate(101);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void universityPassRateSmallerThan_0_ThrowsException() {
			versity.passRate(-1);
		}
		
		@Test
		public void testUniversityCourseListHasCourses() {
				versity.createCourse(
						"clerk", // user
						"CS", // title,
						110022, // code
						26, // capsize
						true, // hasAFinal
						2, // numberOfAssignments,
						1, // numberOfMidterms,
						true, // enforcePrereqs)
						false // isProjectCourse
						);
				assertEquals(1, versity.courses().size());
			}
			
		@Test(expected = IllegalArgumentException.class)
		public void attemptToCreateDuplicateCourseWithSameCodeThrowsException() {
				versity.createCourse(
						"clerk", // user
						"CS", // title,
						110022, // code
						26, // capsize
						true, // hasAFinal
						2, // numberOfAssignments,
						1, // numberOfMidterms,
						true, // enforcePrereqs)
						false // isProjectCourse
						);
				versity.createCourse(
						"clerk", // user
						"CS", // title,
						110022, // code
						26, // capsize
						true, // hasAFinal
						2, // numberOfAssignments,
						1, // numberOfMidterms,
						true, // enforcePrereqs)
						false // isProjectCourse
						);
			}
			
		@Test
		public void testUniversityStudentListHasStudents() {
					versity.createStudent("John", 1,"Part time");
					versity.createStudent("Noah", 2,"Full time");
					assertEquals(2, versity.students().size());
				}
				
		@Test(expected = IllegalArgumentException.class)
		public void attemptToCreateDuplicateStudentWithSameNumberThrowsException() {
					versity.createStudent("John", 1,"Part Time");
					versity.createStudent("Noah", 1,"Full time");
				}

}