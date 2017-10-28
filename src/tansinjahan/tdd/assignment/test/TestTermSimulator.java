package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tansinjahan.tdd.assignment.TermEventListener;
import tansinjahan.tdd.assignment.TermSimulator;

public class TestTermSimulator extends TermSimulator {

	public TestTermSimulator(TermEventListener listener) {
		super(listener);
	}

	public void endTerm() {
		listener.onTermEnded();
	}

	public void startTerm() {
		listener.onTermProperlyStarted();
	}

	public void termAllowCourseRegistration() {
		listener.onRegistrationPossible();
	}

	public void termCreated() {
		listener.onCreate();
	}
	
	public void twoWeeksPassesTillTermStarted() {
		listener.onTwoWeekPassedTillTermStarted();
	}
}