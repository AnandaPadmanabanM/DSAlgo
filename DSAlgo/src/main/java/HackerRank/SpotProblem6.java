package RandomProblems;

import org.junit.Test;

public class SpotProblem6 {
	/*
			Problem Statement
			
			
		*/

	/*
	   1. 
	  	  Input(s):
		  Output :
		  Constraint(s):
	   
	   2. Test data
			Positive : 
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : 
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "oneTwoThree";
		camelcase(s);
	}

	@Test
	public void testData02() { // Negative
		
	}

	@Test
	public void testData03() { // Edge
	
	}
	
	public int camelcase(String s) {
	    // Write your code here
		int count=0;
	     for (int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) count++;			
		}
	     System.out.println(count);
		return count+1;
	    }	
}
