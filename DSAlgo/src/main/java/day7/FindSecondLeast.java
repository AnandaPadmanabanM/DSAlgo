package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class FindSecondLeast {
	/*
	 * Given an array of integers temperatures represents the daily temperatures,
	 * return an array answer such that answer[i] is the number of days you have to
	 * wait after the ith day to get a warmer temperature. If there is no future day
	 * for which this is possible, keep answer[i] == 0 instead.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
	 * 
	 * 
	 * Input - String Output- int Constraints- no constraints
	 * 
	 * 2. Test data set
	 * 
	 * Positive : Negative : Edge :
	 * 
	 * 3. Solution Approach:
	 * 
	 * 4. O-Notation:
	 * 
	 * 5. Pseudocode: 1) if the length of the input, target
	 * 
	 */

	@Test
	public void testData01() // positive
	{
		String input = "aabbcdd";
		Assert.assertTrue(findSecondLeastCharacter(input)=='a');
	}


	private Character findSecondLeastCharacter(String input){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
	
		for(int  i=0; i<input.length(); i++){
			map.put(input.charAt(i),map.getOrDefault(input.charAt(i),0)+1);
		}
		for(Entry<Character, Integer> entry: map.entrySet()) {
			 if (entry.getValue()== 2) return entry.getKey();
		}
		
		return null;
		
	}
	
	private Character findSecondLeastCharacterUsingBrute(String input){
	
		for(int  i=0; i<input.length(); i++){
			for (int j = i+1; j < input.length(); j++) {
				
			}
			
		}	
		return null;
	}
	
	
}
