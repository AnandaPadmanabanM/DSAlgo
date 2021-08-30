package RandomProblems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class FirstUniqueCharacter {
	/*
			Problem Statement
			
			
		*/

	/*
	   1. 
	  	  Input(s):String
		  Output :Integer
		  Constraint(s): O{n)
	   
	   2. Test data
			Positive : statistics
			Negative : bbee
			Edge     : 
	
	   3.  Approaches Known 
			 Approach : 
	
	   4.  O - Notation O(n) Space - O(n), Time - O(n)
			  
	
	   5.  Pseudocode	
	   		1. Initialise the hash map to have no. of Occurences of the character
	   		2. Traverse through the hash map and get charcter whaich has single occurence
	   		3. Get the index of the charcater in the String
	   		4. Return index+1 else -1
	   			
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input="aabcc";
		Assert.assertTrue(findUniqueCharacter(input)==3);
	}

	@Test
	public void testData02() { // Negative
		String input="bbee";
		Assert.assertTrue(findUniqueCharacter(input)==-1);
	}

	@Test
	public void testData03() { // Edge
		String input="statistics";
		Assert.assertTrue(findUniqueCharacter(input)==3);
	}
	
	
	private int findUniqueCharacter(String input) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
		}
		int min=Integer.MAX_VALUE;
		for(Character each: map.keySet()) {
			int value=map.get(each);
			if(value==1) {
				min=Math.min(input.indexOf(each), min);
			}
		}
		System.out.println(min);	
		return min!=Integer.MAX_VALUE ?min+1:-1;
	}
}
