package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class GroupAnagrams {
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
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String[] input= {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> out = new ArrayList<>();
		out.add(Arrays.asList("nat","tan"));
		System.out.println(groupAnagrams(input));
	}
	
	@Test
	public void testData02() { // Positive
		String[] input= {};
		List<List<String>> out = new ArrayList<>();
		out.add(Arrays.asList("nat","tan"));
		System.out.println(groupAnagrams(input));
	}


	 public List<List<String>> groupAnagrams(String[] input) {
		 if (input.length == 0) return new ArrayList<>();
			Map<Map<Character, Integer>, List<String>> outMap = new HashMap<>();
			for (String eachVal : input) {
				Map<Character, Integer> currentMap = new HashMap<>();
				for (int i = 0; i < eachVal.length(); i++) {
					currentMap.put(eachVal.charAt(i), currentMap.getOrDefault(eachVal.charAt(i), 0) + 1);
				}
		  		if (outMap.containsKey(currentMap)) {
					List<String> list = outMap.get(currentMap);
					list.add(eachVal);
					outMap.put(currentMap, list);
				} else {
					List<String> list = new ArrayList<>(Arrays.asList(eachVal));
					outMap.put(currentMap, list);
				}
			}
			List<List<String>> retList = new ArrayList<>(outMap.values());	
			return retList;
	    }
}
