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
		if(midterm==0 && assignments==0 && hasFinal==false){
			String C_grade_Element="your course must have at least one grade element";
			return C_grade_Element;
		}
		else 
			if((midterm>0 && midterm<=2)||(assignments>=0&& assignments<=5)||hasFinal==true){ 
				return courseTitle;
				}
			else
				return "course grade is not correct";
	}
	public int getCourseCode(){
		if((mycode/100000) !=0){
			return mycode;	
		}
		else 
			return 0;
	}
	

}
