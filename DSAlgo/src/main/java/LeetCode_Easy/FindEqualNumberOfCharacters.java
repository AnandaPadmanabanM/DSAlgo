package LeetCode_Easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class FindEqualNumberOfCharacters {
	/*
			Problem Statement
			1941. Check if All Characters Have Equal Number of Occurrences
			
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
		1) Initialise Map and all input characters with occurences
		2) Iterate through the map values and check if the vlaue is same for all keys
		      If value is not same, return false
		3) Return true;
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "abacbc";
		Assert.assertTrue(findEqualCharacters(s)==true);
	}

	private boolean findEqualCharacters(String s) {
		 Map<Character,Integer> map=new HashMap<>();
	       int left=0;
	       while(left<s.length())
	           map.put(s.charAt(left),map.getOrDefault(s.charAt(left++),0)+1);       
	       for(int val:map.values())
	           if(val!=map.get(s.charAt(0))) return false;
	      return true;  
	}

	
}
