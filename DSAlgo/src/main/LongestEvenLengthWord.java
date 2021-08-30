package RandomProblems;

import org.junit.Test;

import junit.framework.Assert;

public class LongestEvenLengthWord {
	/*
			Problem Statement
			
			
		*/

	/*
	   1. 
	  	  Input(s): String
		  Output : String
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
		String input="Time to write great codegh";
		Assert.assertTrue(findEvenWord(input).equals("codegh"));
	}

	private String findEvenWord(String input) {
		String[] inputarray=input.split("\\s+");
		int index=0; String out="";
		for (int i = 0; i < inputarray.length; i++) {
			 if(inputarray[i].length()%2 ==0 && inputarray[i].length()>index) {
			 index=Math.max(inputarray[i].length(),index);
			 out=inputarray[i];
			 }		
		}

		System.out.println(out);
		return out;
	}

	}
