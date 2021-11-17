package ClassRoom;

import org.junit.Test;

import junit.framework.Assert;

public class FindShortestBalancedFragment {
	/*
			Problem Statement
			Palo Network Question 1
			
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
		String s="azABaabza";
		Assert.assertTrue(findShortestBalancedFragment(s)==5);
	}
	
	@Test
	public void testData02() { // Negative
		String s="TacoCat";
		Assert.assertTrue(findShortestBalancedFragment(s)==-1);
	}

	@Test
	public void testData03() { // Edge
		String s="AcZCbaBz";
		Assert.assertTrue(findShortestBalancedFragment(s)==8);
	}

	private int findShortestBalancedFragment(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
