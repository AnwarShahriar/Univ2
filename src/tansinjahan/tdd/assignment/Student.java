package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import utilities.Trace;


public class Student {
	private int studentNumber;
	private String studentName;
	private boolean fullTime;
	private int maxCourseCount;
	
	private String email;
	private String password;
	
	List<Integer> courseIDs=new ArrayList<>();
	private List<Course> registeredCourses = new ArrayList<>();
	private List<Course> completedCourses = new ArrayList<>();
	private List<Course> selectedCourses = new ArrayList<>();
	private Map<Course, String> dropedCourseMap = new HashMap<>();
	
	Logger logger = Trace.getInstance().getLogger(this);
	
	public Student(String name,int studentID, String studentStatus){
		this.studentNumber=studentID;
		this.studentName=name;
		setMaxCourseOfStudent(studentStatus);
	}
	
	public String getName() {
		return studentName;
	}

	public int getStudentNumber() {
		return studentNumber;
}

	public void setMaxCourseOfStudent(String studentStatus) {
		if(studentStatus.equalsIgnoreCase("full time")){
			maxCourseCount = 4;
		}
		else 
			maxCourseCount = 2;	
	}
	
	public void setEmail(String email) {
				this.email = email;
			}
			
	public void setPassword(String password) {
				this.password = password;
			}
			
	public String getEmail() {
				return email;
			}
			
	public String getPassword() {
				return password;
			}
	
	public void registerCourse(Course course){
		if (!selectedCourses.contains(course)) {
			 		String errMsg = String.format("Course %s is not on selected course list", course.title);
			 			throw new IllegalStateException(errMsg);
			 		}
		if (alreadyRegistered(course)) {
						throw new IllegalStateException("Already registered for course");
					}
					
		if (registeredCourses.size() == maxCourseCount) {
						throw new IllegalStateException(String.format("Max course count for %s student is %d", (fullTime ? "full time" : "part time"), maxCourseCount));
					}
		selectedCourses.remove(course);
		registeredCourses.add(course);
		logger.info(String.format(" Student registered in the selected course titled: %s", course));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNumber != other.studentNumber)
			return false;
		return true;
	}

	private boolean alreadyRegistered(Course course) {
		return registeredCourses.contains(course);
	}

	public List<Course> currentCourses() {
		return registeredCourses;
	}
	
	public void completedCourse(Course course) {
		if (!registeredCourses.contains(course)) { 
			 	String errMsg = String.format("Course %s is not registered by Student %d", course.title, studentNumber);
			 	throw new IllegalArgumentException(errMsg);
			 	}
			 	completedCourses.add(course);
	}
			 
	public List<Course> completedCourses() {
			 	return completedCourses;
	}
	
	public void selectCourse(Course course) {
		if (selectedCourses.contains(course)) {
						String errMsg = String.format("Course %s is already selected and cannot be re-selected", course.title);
						throw new IllegalArgumentException(errMsg);
			} 
		
		if (registeredCourses.contains(course)) {
		 		String errMsg = String.format("Course %s is already registered and cannot be selected", course.title);
		 		throw new IllegalArgumentException(errMsg);
		 	}
		 		
		 if (completedCourses.contains(course)) {
		 		String errMsg = String.format("Course %s is already completed and cannot be selected", course.title);
		 		throw new IllegalArgumentException(errMsg);
		 	}
		 selectedCourses.add(course);
		 logger.info(String.format(" Student selected the course: %s", course));
	}
		 
	public List<Course> selectedCourses() {
		 		return selectedCourses;
		 	}
	
	public boolean dropCourse(Course course) {
		 if (registeredCourses.contains(course)) {
		 		registeredCourses.remove(course);
		 		dropedCourseMap.put(course, "DR");
		 		logger.info(String.format(" Student dropped the course titled: %s", course));
		 		return true;
		 	}
		 		return false;
		 }
		 
	public boolean deRegisterCourse(Course course) {
		 		return registeredCourses.remove(course);
		 	}
}
