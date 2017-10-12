package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;
import tansinjahan.tdd.assignment.Student;

public class Course {

	/*boolean enforcePrerequisites;
	int midterm;
	int assignments;
	boolean hasFinal;
	int capsize;
	String courseTitle;
	int mycode;
	List<Student> students=new ArrayList<Student>();
	List<Integer> marksOfStudent= new ArrayList<Integer>();
	List<Integer> prerequisites= new ArrayList<Integer>();
	int[] weightOfassignments;
	int[] weightOfMidterms;
	int weightOfFinal;*/
	
	private String title;
	private int capsize;
	private int code;
	private boolean hasAFinal;
	private int numberOfAssignments;
	private int numberOfMidterms;
	private boolean enforcePrereqs;
	
	public Course(String title, int capsize) {
		 		this.title = title;
		 		this.capsize = capsize;
		 	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code; 
	}
	
	public void setHasAFinal(boolean hasfinal){
		this.hasAFinal = hasfinal;
	}

	public void setAssignments(int assignments) {
		this.numberOfAssignments = assignments; 
		
	}

	public void setMidterm(int midterm) {
		this.numberOfMidterms = midterm;
		
	}

	public void setPrerequisites(boolean prerequisites) {
		this.enforcePrereqs = prerequisites;
		
	}

}
