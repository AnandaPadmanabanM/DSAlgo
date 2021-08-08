package day6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class Problem {

	/*
	 *   Given two strings s1 and s2, return true if s2 contains the permutation of s1.
		In other words, one of s1's permutations is the substring of s2.
		
		Example 1:
		
		Input: s1 = "ab", s2 = "eidbaooo"
		Output: true
		Explanation: s2 contains one permutation of s1 ("ba").
		Example 2:
		
		Input: s1 = "ab", s2 = "eidboaoo"
		Output: false
	 * 
	 * 
	 * 
	Input - String
    Output- boolean
    Constraints- sliding window
     
	2. Test data set

	        Positive : s1="ab" s2="jkbac"
	        Negative : s1="cb" s2="adef"
	        Edge     : s1=""  s2="abc"

	3. Solution Approach: 2 pointer 

	4. O-Notation:

	5. Pseudocode
		1) Intiliase left and right indeces as zero
		2) Initiase the map and add the s1 values to it
		3) Check for 
	
	
	*/




	@Test
	public void testData01() // Positive
	{
		String s1="ab";
		String s2="chebaf";
		Assert.assertTrue(findPermutation(s1,s2)==true);
	}
	

//
//	@Test
//	public void testData02() // negative
//	{
//		
//		Assert.assertTrue();
//	}
//	
//	@Test
//	public void testData03() // edge
//	{
//		
//		Assert.assertTrue();

	private boolean findPermutation(String s1, String s2) {
		Map<Character,Integer> patternMap= new HashMap<>();
		Map<Character,Integer> searchMap= new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			patternMap.put(s1.charAt(i), patternMap.getOrDefault(s1.charAt(i), 0)+1);
			searchMap.put(s2.charAt(i), searchMap.getOrDefault(s2.charAt(i), 0)+1);
			
		}	
		if(patternMap.equals(searchMap)) return true;
		else {
			for (int i = 1; i < s2.length()-s1.length(); i++) {
				if(searchMap.get(s2.charAt(i-1))>1)
				searchMap.put(s2.charAt(i-1), searchMap.getOrDefault(s2.charAt(i-1), 0)-1);
				else searchMap.remove(s2.charAt(i-1));
				searchMap.put(s2.charAt(i+1), searchMap.getOrDefault(s2.charAt(i+1), 0)+1);
			}
			if(patternMap.equals(searchMap)) return true;
		}
		
		return false;
	}

//	}



}
