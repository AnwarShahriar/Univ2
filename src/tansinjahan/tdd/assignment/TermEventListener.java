package tansinjahan.tdd.assignment;

public interface TermEventListener {
	void onCreate();
	void onRegistrationPossible();
	void onTermProperlyStarted();
	void onTermEnded();
	void onTwoWeekPassedTillTermStarted();
}
