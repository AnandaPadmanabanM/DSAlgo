package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindWordPattern {
	/*
			Problem Statement
			Input: pattern = "abba", s = "dog cat cat dog"
			Output: true
			
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
		String s1="abab";
		String s2="dad mom dad mom";
		findWordPattern(s1,s2);
	}

	public boolean findWordPattern(String pattern, String s) {
		Map<Character, String> map = new HashMap<Character, String>();
		String[] split = s.split(" ");
		if (pattern.length() != split.length)
			return false;
		for (int i = 0; i < split.length; i++) {
			char inputChar = pattern.charAt(i);
			String str = split[i];

			if (!map.containsKey(inputChar) && !map.containsValue(str)) {
				map.put(inputChar, str);
			}

			else if (map.containsKey(inputChar) && !map.get(inputChar).equalsIgnoreCase(str)) {
				return false;
			}

			else if (map.containsValue(str) && !map.containsKey(inputChar)) {
				return false;
			}

		}
		return true;

	}
}
