package cucumbertest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import server.logic.handler.InputHandler;
import server.logic.handler.OutputHandler;
import tansinjahan.tdd.assignment.Student;
import tansinjahan.tdd.assignment.StudentTable;
import tansinjahan.tdd.assignment.University;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cucumberStepDefinitions {
	
	InputHandler handler = new InputHandler();
	OutputHandler o= new OutputHandler();
	int state;
	
	@Given("^the university is initialized$")
	public void the_university_is_initialized() throws Exception {
		StudentTable.getInstance().clear();
		Student student1 = new Student("Jim", 11111,"Full time");
 		student1.setEmail("jim@gotham");
 		student1.setPassword("12345");
		StudentTable.getInstance().add(student1);
		
		Student student2 = new Student("Lee", 22222,"Full time");
 		student2.setEmail("lee@gotham");
 		student2.setPassword("12345");
 		StudentTable.getInstance().add(student2);
 		
 		University.getInstance();
		state = handler.processInput("", InputHandler.WAITING).getState();
	}
	
	@Given("^the user inputs clerk$")
	public void the_user_inputs_clerk() throws Exception {
		state = handler.processInput("clerk", state).getState();
	}
	
	@When("^the clerk logs in with (.*)$")
	public void the_clerk_logs_in_with(String password) throws Exception {
		state = handler.processInput(password, state).getState();
	}
	
	@Then("^the clerk is logged in$")
	public void the_clerk_is_logged_in() throws Exception {
		assertThat(state, equalTo(OutputHandler.CLERK));
	}
	
	@Then("^the clerk is not logged in$")
	public void the_clerk_is_not_logged_in() throws Exception {
		assertThat(state, equalTo(OutputHandler.CLERKLOGIN));
	}
	
	@Given("^the user inputs student$")
	public void the_user_inputs_student() throws Exception {
		state = handler.processInput("student", state).getState();
		
	}

	@When("^the student logs in with (.*) (.*)$")
	public void the_student_logs_in_with_(String email,String pass) throws Exception {
		state = handler.processInput(email +","+ pass, state).getState();
		System.out.println(state);
	}

	@Then("^the student is logged in$")
	public void the_student_is_logged_in() throws Exception {
		assertThat(state, equalTo(OutputHandler.STUDENT));
	}

}
