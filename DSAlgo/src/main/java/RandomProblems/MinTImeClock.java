package RandomProblems;

import org.junit.Test;

import junit.framework.Assert;

public class MinTImeClock {
	/*
			Problem Statement
			
			
		*/

	/*
	   1. 
	  	  Input(s): String
		  Output : integer
		  Constraint(s):
	   
	   2. Test data
			Positive : 
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : 
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode	
	   1) Convert string to char array
	   2) Find the value of the upper case character by using ASCII value (difference by 65)
	   3) Initialise the totalTime
	   4)Traverse the character array and find the difference between charcaters for clock wise
	   		- ALso find the anti clock value with the formula (26-difference) 
	   		- Find the min of above 2 values and add it to the totalTime  		
	   5)Return totalTime
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input="BZA";
		Assert.assertTrue(findMinTime(input)==4);
	}

	@Test
	public void testData02() { // 
		String input="XYZAB";
		Assert.assertTrue(findMinTime(input)==7);
	}

	@Test
	public void testData03() { // Edge
		String input="AA";
		Assert.assertTrue(findMinTime(input)==0);
	}
	
	private int findMinTime(String input) {
		int timeTaken = 0;
		char start='A';
		for (int i = 0; i < input.length(); i++) {
			int clock = Math.abs(input.charAt(i)-start);
			int antiClock=26-clock;
			timeTaken+=Math.min(clock,antiClock);
			start=input.charAt(i);
		}
		System.out.println(timeTaken);	
		return timeTaken;
	}
}
