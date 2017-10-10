package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;
import tansinjahan.tdd.assignment.Course;

public class University {
	private List<Course> courses=new ArrayList<>();
	
	public Course createCourse(String title, int capsize) {
		 		return new Course(title, capsize);
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
}
