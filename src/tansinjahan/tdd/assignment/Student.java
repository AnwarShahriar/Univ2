package tansinjahan.tdd.assignment;

import java.util.ArrayList;

public class Student {
	int studentNumber;
	String studentName;
	String status;
	//List<Course> courses= new ArrayList<Course>();
	public Student(int studentID,String name,String studentStatus){
		this.studentNumber=studentID;
		this.studentName=name;
		this.status=studentStatus;
	}

}
