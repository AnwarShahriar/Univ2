package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;

import server.logic.tables.StudentTable;

public class Student {
	private int studentNumber;
	private String studentName;
	private String status;
	private boolean fullTime;
	private int maxCourseCount;
	
	List<Integer> courseIDs=new ArrayList<>();
	
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
		if(studentStatus == "full time"){
			maxCourseCount = 4;
		}
		else 
			maxCourseCount = 2;
			
		
	}
	
	public void registerCourse(Course course){
		if (alreadyRegistered(course.getCode())) {
						throw new IllegalStateException("Already registered for course");
					}
					
					if (courseIDs.size() == maxCourseCount) {
						throw new IllegalStateException(String.format("Max course count for %s student is %d", (fullTime ? "full time" : "part time"), maxCourseCount));
					}
		
		courseIDs.add(course.getCode());
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

	private boolean alreadyRegistered(int code) {
		for (int id : courseIDs) {
						if (id == code) {
							return true;
						}
					}
					return false;
	}

	public List<Course> currentCourses() {
		return CourseTable.getInstance().getCourses(courseIDs);
	}
	

}
