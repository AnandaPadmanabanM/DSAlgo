package ClassRoom;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseSentenceByWord {
	/*
			Problem Statement
			Reverse the given sentence by its word
			
			
		*/

	/*
	   1. 
	  	  Input(s): String
		  Output : String
		  Constraint(s): less than O(N)
	   
	   2. Test data
			Positive : 
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : 
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode		
			1) Split given input based on the white space and make it as array
			2) Initialise the StringBuilder
			3) Iterate through the array and append it from the last index to the StringBulder
			4) Return StringBuider as String
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "today is good";
		Assert.assertTrue(reverseSentenceByWord(input).equals("good is today"));
	}
	
	@Test
	public void testData02() { // Edge
		String input = "today";
		Assert.assertTrue(reverseSentenceByWord(input).equals("today"));
	}

	@Test
	public void testData03() { // Negative
		String input = " ";
		Assert.assertTrue(reverseSentenceByWord(input).equals(""));
	}

	private String reverseSentenceByWord(String input) {
		// TODO Auto-generated method stub
		String[] eachInput = input.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = eachInput.length-1; i >= 0; i--) {
			sb.append(eachInput[i]);
			if(i>0) sb.append(" ");
		}	
		return sb.toString();
	}
	
	private String reverseSentenceByWordOpt(String input) {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}


}
