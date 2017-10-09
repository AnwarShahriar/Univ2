package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;

public class University {
	private List<Course> courses=new ArrayList<>();
	
	public Course createCourse(String title, int capsize) {
		 		return new Course(title, capsize);
		 	}
	public String getName() {
		return "Carleton";
	}
}
