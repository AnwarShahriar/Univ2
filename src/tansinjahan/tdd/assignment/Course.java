package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.List;

public class Course {

	boolean enforcePrerequisites;
	int midterm;
	int assignments;
	boolean hasFinal;
	int capsize;
	String courseTitle;
	int mycode;
	List<Student> students=new ArrayList<Student>();
	List<Integer> prerequisites= new ArrayList<Integer>();
	int[] weightOfassignments;
	
	public Course(boolean enforceprereq, int mid, int assign, boolean hasFinal,
			int capsize, String title, int courseCode) throws IllegalArgumentException{
		validateCourseCode(courseCode);
		validateCourseGradeElement(mid, assign, hasFinal);
		
		this.enforcePrerequisites = enforceprereq;
		this.midterm = mid;
		this.assignments = assign;
		this.hasFinal = hasFinal;
		this.capsize = capsize;
		this.courseTitle = title;
		this.mycode = courseCode;
		weightOfassignments= new int[assign];
	}

	private void validateCourseGradeElement(int mid, int assign,
			boolean hasFinal)throws IllegalArgumentException {
		if(mid==0 && assign==0 && hasFinal==false){
			throw new IllegalArgumentException("your course must have at least one grade element");
		}
		else 
			if((mid>0 && mid<=2)||(assign>=0&& assign<=5)||hasFinal==true){ 
				return;
				}
			else
				throw new IllegalArgumentException("your course must have at least one grade element");
		
	}

	private void validateCourseCode(int courseCode)throws IllegalArgumentException {
		if((courseCode/100000) ==0){
			throw new IllegalArgumentException("Course code first digit invalid");
		}
	}

	public String title() {
		return courseTitle;
	}
	public int getCourseCode(){
		return mycode;
	}
	public List<Student> getStudents(){
		return students;
	}

	public void addStudent(Student std) {
		students.add(std);
	}
	public List<Integer> prerequisitesOfCourse(){
		return prerequisites;
	}

	public void addPrerequisite(int prerequisiteCode) {
		prerequisites.add(prerequisiteCode);
	}
	public void setWeightOfAssignment(int assignmentNumber, int weight){
		weightOfassignments[assignmentNumber - 1] = weight;
	}

	public int weightOfAssignment(int assignmentNumber) {
		return weightOfassignments[assignmentNumber - 1];
	}
	

}
