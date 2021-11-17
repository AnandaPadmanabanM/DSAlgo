package Recursion;

import org.junit.Test;

public class FindSubStringCount {
	/*
			Problem Statement
			
			
		*/

	/*
	   1. Identify base case -> nums.length <= 0
	   2. Have test data -> 	{0,1,1,0,0,1}
	   3. Have edge case  ->     {0,0,0,0}
	   4. Logic has to be identified ->
	  	  	
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input1="World is beautiful";
		String input2 ="is";
		System.out.println(findSubStringCount(input1,input2));
	}
	
	@Test
	public void testData02() { // Positive
		String input1="World beautiful";
		String input2 ="is";
		System.out.println(findSubStringCount(input1,input2));
	}
	
	private int findSubStringCount(String input1, String input2) {
		
		if(input1.contains(input2)) 
			return 1+findSubStringCount(input1.replaceFirst(input2, ""),input2);
		
		return 0;
	}

	
}
