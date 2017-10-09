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
	
	/*private void validateCourseGradeElement(int mid, int assign,
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
	
	private int totalAssignmentWeight() {
		int res = 0;
		for (int weight : weightOfassignments) {
			res += weight;
		}
		return res;
	}
	
	private int totalMidtermWeight() {
		int res = 0;
		for (int weight : weightOfMidterms) {
			res += weight;
		}
		return res;
	}
	
	public void setWeightOfAssignment(int assignmentNumber, int weight){
		if (totalWeight() < 100 && totalWeight() + weight <= 100) {
			weightOfassignments[assignmentNumber - 1] = weight;
		} else {
			throw new IllegalStateException("Weights cannot go above 100");
		}
	}
	
	public void setWeightOfMidterm(int midtermNumber, int weight) {
		if (totalWeight() < 100 && totalWeight() + weight <= 100) {
			weightOfMidterms[midtermNumber - 1] = weight;
		} else {
			throw new IllegalStateException("Weights cannot go above 100");
		}
	}
	
	public void setWeightOfFinal(int weight) {
		if (totalWeight() < 100 && totalWeight() + weight <= 100) {
			weightOfFinal = weight;
		} else {
			throw new IllegalStateException("Weights cannot go above 100");
		}
	}
	
	private int totalWeight() {
		return totalAssignmentWeight() + totalMidtermWeight() + weightOfFinal;
	}

	public int weightOfAssignment(int assignmentNumber) {
		return weightOfassignments[assignmentNumber - 1];
	}
	
	public int weightOfMidterms(int midNumber) {
		return weightOfMidterms[midNumber - 1];
	}
	
	public int weightOfFinal() {
		return weightOfFinal;
	}

	public int markForStudent(Student student) {
		return student.;
	}*/

}
