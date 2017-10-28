package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import tansinjahan.tdd.assignment.StudentTable;
import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.ProjectCourse;
import utilities.Trace;
import tansinjahan.tdd.assignment.TermEventListener;;

public class University implements TermEventListener{
		
		private List<Course> courses=new ArrayList<>();
		
		
		private static final University INSTANCE = new University();
		private Logger logger = Trace.getInstance().getLogger(this);
		
		private TermState termState = TermState.NONE;
		
		private int universityCourseCount = 25; // Default course count 25
		private int passRate = 70; // Default pass rate is 70
		
		public Course createCourse(
							String user, 
							String title, 
							int code, 
							int capsize, 
							boolean hasAFinal, 
							int numberOfAssignments, 
							int numberOfMidTerms, 
							boolean enforcePrereqs, 
							boolean isProjectCourse) {
				if (hasCourseExists(code)) {
							String errMsg = String.format("Course with code %d already exists", code);
							throw new IllegalArgumentException(errMsg);
						}
				CourseInteractor interactor = new CourseInteractor(this);
				Course course = interactor.createCourse(user, title, code, capsize, hasAFinal, numberOfAssignments, numberOfMidTerms, enforcePrereqs, isProjectCourse);
				CourseTable.getInstance().add(course);
				return course;
		}
		
		
		public enum TermState {
			 		NONE,
			 		CREATE_STUDENT_COURSE_STATE,
			 		COURSE_REGISTRATION_STATE,
			 		TERM_PROPERLY_STARTED_STATE,
			 		TERM_END_STATE
			 	}
		
		public TermState getTermState() {
			 		return termState;
			 	}
			 
		@Override
		public void onCreate() {
			 	termState = TermState.CREATE_STUDENT_COURSE_STATE;
			 	}
			 
		@Override
		public void onRegistrationPossible() {
			 	termState = TermState.COURSE_REGISTRATION_STATE;
			 	}
			 
		@Override
		public void onTermProperlyStarted() {
				termState = TermState.TERM_PROPERLY_STARTED_STATE;
			 	}
			 
		@Override
		public void onTermEnded() {
			 	termState = TermState.TERM_END_STATE;
			 	}
			 
		public String getName() {
			return "Carleton";
		}
		
		public boolean hasCourseExists(int code) {
			for (Course c : CourseTable.getInstance().courses) {
				if(c.getCode()== code) {
					return true;
				}
			}
			return false;
		}
		
		public List<Course> courses() {
					return CourseTable.getInstance().courses;
		}
		
		public Student createStudent(String name, int studentNumber, String status) {
			Student student = new Student(name, studentNumber, status);
			StudentTable.getInstance().add(student);
			return student;
		}
		
		public static University getInstance() {
			return INSTANCE;
		}
		
		public void registerStudentForCourse(Student student, Course course) {
					try {
						student.registerCourse(course);
					} catch (Exception e) {
						logger.info(e.getMessage());
						throw e;
					}
		}
		
		public void universityCourseCount(int count) {
					if (count < 1 || count > 25) {
						String errMsg = "University course count must be between 1 and 25";
						throw new IllegalArgumentException(errMsg);
					}
					this.universityCourseCount = count;
		}
			
		public int getUniversityCourseCount() {
					return universityCourseCount;
		}
			
		public void passRate(int passRate) {
					if (passRate < 0 || passRate > 100) {
						String errMsg = "Pass rate must be between 0 and 100";
						throw new IllegalArgumentException(errMsg);
					}
					this.passRate = passRate;
		}
				
		public int getPassRate() {
					return passRate;
		}

}
