package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import tansinjahan.tdd.assignment.StudentTable;
import tansinjahan.tdd.assignment.Course;
import tansinjahan.tdd.assignment.ProjectCourse;
import utilities.Trace;

public class University {
	private List<Course> courses=new ArrayList<>();
	Logger logger = Trace.getInstance().getLogger(this);
	private static final University INSTANCE = new University();
	
	public Course createCourse(String title, int capsize,boolean hasProject) {
		Course course = hasProject? new ProjectCourse(title, capsize): new Course(title, capsize);
		CourseTable.getInstance().add(course);
		return course;
		 	}
	
	public String getName() {
		return "Carleton";
	}
	
	public boolean hasCourseExists(int code) {
		for(Course c: courses) {
			if(c.getCode()== code) {
				return true;
			}
		}
		return false;
	}
	
	public Student createStudent(String name, int studentNumber, String status) {
		Student student = new Student(name, studentNumber, status);
		StudentTable.getInstance().add(student);
		return student;
}
	
	public static University getInstance() {
		return INSTANCE;
	}
}
