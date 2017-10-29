package tansinjahan.tdd.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import tansinjahan.tdd.assignment.Student;

public class Course {
	
	protected String title;
	protected int capsize;
	protected int code;
	protected boolean hasAFinal;
	protected int numberOfAssignments;
	protected int numberOfMidterms;
	protected boolean enforcePrereqs;
	
	protected int[] assignmentWeights;
	protected int[] midTermWeights;
	protected int finalWeight;
	
	List<Student> students = new ArrayList<>();
	List<Integer> preRequisites = new ArrayList<>();
	
	Map<Integer, Integer> studentIdVsMarksMap = new HashMap<>();
	
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
		generateWeight();
	}

	public void setNumberOfAssignments(int assignments) {
		this.numberOfAssignments = assignments; 
		assignmentWeights = new int[numberOfAssignments];
		generateWeight();
		
	}

	public void setNumberOfMidterm(int midterm) {
		this.numberOfMidterms = midterm;
		midTermWeights = new int[numberOfMidterms];
		generateWeight();
		
	}

	public void setPrerequisites(boolean prerequisites) {
		this.enforcePrereqs = prerequisites;
		
	}
	
	public int weightOfAssignment(int assignmentNumber) {
				return assignmentWeights[assignmentNumber - 1];
	}
			
	public int weightOfMidterm(int midtermNumber) {
				return midTermWeights[midtermNumber - 1];
	}
			
	public int weightOfFinal() {
				return finalWeight;
	}
			
	public boolean hasProject() {
				return false;
	}
	
	protected void generateWeight() {
				int remainWeightToAssign = 100;
				if (numberOfAssignments > 0) {
					int gradeElems = numberOfAssignments + numberOfMidterms + (hasAFinal ? 1 : 0);
					remainWeightToAssign = assignWeight(assignmentWeights, numberOfAssignments, gradeElems, remainWeightToAssign);
				}
				
				if (numberOfMidterms > 0) {
					int gradeElems = numberOfMidterms + (hasAFinal ? 1 : 0);
					remainWeightToAssign = assignWeight(midTermWeights, numberOfMidterms, gradeElems, remainWeightToAssign);
				}
				
				if (hasAFinal) {
					finalWeight = remainWeightToAssign;
				}
	}
	
	protected int assignWeight(int[] weightArr, int elemCount, int remainGradeElemCount, int totalWeight) {
				double totalGradeElems = remainGradeElemCount;
				
				double assignmentPercentage = (totalWeight / totalGradeElems) * elemCount;
				int totalAllotedAssignmentWeight = 0;
				for (int i = 0; i < elemCount; i++) {
					int weight = (int) ThreadLocalRandom.current().nextDouble(1, assignmentPercentage / elemCount);
					weightArr[i] = weight;
					totalAllotedAssignmentWeight += weight;
					
					if (i == elemCount - 1) {
						int extraWeight = (int) assignmentPercentage - totalAllotedAssignmentWeight;
						totalAllotedAssignmentWeight += extraWeight;
						weightArr[i] = weight + extraWeight;
					}
				}
				totalWeight -= totalAllotedAssignmentWeight;
				
				return totalWeight;
	}
	
	public boolean isFull() {
		 		return students.size() == capsize;
	}
	
	public boolean addStudent(Student student) {
		 		if (students.contains(student) || isFull()) return false;
		 		return students.add(student);
	}
	
	public boolean removeStudent(Student student) {
		 		return students.remove(student);
	}
	
	public List<Student> students() {
		 		return students;
	}
		 	
	public List<Integer> preRequisites() {
		 		return preRequisites;
	}
	
	public boolean addPreRequisite(int courseCode) {
		 		return preRequisites.add(courseCode);
	}
	
	public int markForStudent(Student student) {
		 		if (!students.contains(student)) {
		 			String errMsg = String.format("Student id %d is not registered in the course", student.getStudentNumber());
		 			throw new IllegalArgumentException(errMsg);
		 		}
		 		
		 		if (studentIdVsMarksMap.containsKey(student.getStudentNumber())) {
		 			return studentIdVsMarksMap.get(student.getStudentNumber());
		 		}
		 		
		 		int mark = ThreadLocalRandom.current().nextInt(80, 98);
		 		studentIdVsMarksMap.put(student.getStudentNumber(), mark);
		 		return mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		Course other = (Course) obj;
		if (code != other.code)
			return false;
		return true;
	}
	
	public String getTitle() {
		 	return title;
	}
		 	
}
