package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tansinjahan.tdd.assignment.Student;
import tansinjahan.tdd.assignment.University;

public class StudentTest {
	private static University versity;
	
	@BeforeClass
	public static void setup() {
		versity = University.getInstance();
	}
	
	@Test
	public void createStudentIDTest(){
		Student student = versity.createStudent("Tansin", 1104, "full time");
		assertEquals(1104,student.getStudentNumber());
	}
	@Test
	public void createStudentNameTest(){
		Student student = versity.createStudent("Tansin", 1104, "full time");
		assertEquals("Tansin",student.getName());
	}
	
	

}
