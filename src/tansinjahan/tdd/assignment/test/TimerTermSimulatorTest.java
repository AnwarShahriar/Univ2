package tansinjahan.tdd.assignment.test;

import static org.junit.Assert.*;
 import java.util.concurrent.CountDownLatch;
 import org.junit.Test;
 import tansinjahan.tdd.assignment.TimerTermSimulator;
 import tansinjahan.tdd.assignment.TermEventListener;
 
 public class TimerTermSimulatorTest {
 
 	@Test
 	public void timerEventOccursInProperOrder() throws InterruptedException {
 		final CountDownLatch latch = new CountDownLatch(1);
 		
 		TimerTermSimulator simulator = new TimerTermSimulator(new TermEventListener() {
 			int order = 0;
 			
 			@Override
 			public void onCreate() {
 				if (order != 0) {
 					fail();
 				}
 				order += 1;
 			}
 			
 			@Override
 			public void onRegistrationPossible() {
 				if (order != 1) {
 					fail();
 				}
 				order += 2;
 			}
 			
 			@Override
 			public void onTermProperlyStarted() {
 				if (order != 3) {
 					fail();
 				}
 				order += 3;
 			}
 			
 			@Override
 			public void onTermEnded() {
 				if (order != 10) { 
 					fail();
 				}
 				latch.countDown();
 			}
 			
 			public void onTwoWeekPassedTillTermStarted() {
 				if (order != 6) {
 					fail();
 				}
 				order += 4;
 			}

 			
 		}, 10); // time is in milliseconds
 		
 		simulator.start();
 		
 		latch.await();
 	}
 
 }