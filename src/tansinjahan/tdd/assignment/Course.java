package tansinjahan.tdd.assignment;

public class Course {

	boolean enforcePrerequisites;
	int midterm;
	int assignments;
	boolean hasFinal;
	int capsize;
	String courseTitle;
	int mycode;

	public Course(boolean enforceprereq, int mid, int assign, boolean hasfinal,
			int capsize, String title, int courseCode) {
		this.enforcePrerequisites = enforceprereq;
		this.midterm = mid;
		this.assignments = assign;
		this.hasFinal = hasfinal;
		this.capsize = capsize;
		this.courseTitle = title;
		this.mycode = courseCode;
		System.out.println("your course" + courseTitle
				+ "has been successfully created");
	}

	public String title() {
		return courseTitle;
	}
	public int getCourseCode(){
		if((mycode/100000) !=0){
			return mycode;	
		}
		else 
			return 0;
	}
	

}
