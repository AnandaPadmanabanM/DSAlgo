package RandomProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class ReorganizeString {
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
	   1. 	
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input="aabccd";
		Assert.assertTrue(ReorganizeString(input).equals("aba"));
	}

	private String ReorganizeString(String input) {
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
		}
		
		return input;
	}
}
