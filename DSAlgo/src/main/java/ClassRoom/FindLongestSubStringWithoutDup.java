package ClassRoom;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class FindLongestSubStringWithoutDup {
	/*
	 * Problem Statement Longest Substring without repeating character
	 * 
	 * 
	 * Given a string s, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
	 * length of 3. Example 2:
	 * 
	 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
	 * of 1. Example 3:
	 * 
	 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
	 * length of 3. Notice that the answer must be a substring, "pwke" is a
	 * subsequence and not a substring. Example 4:
	 * 
	 * Input: s = "" Output: 0
	 * 
	 * 
	 */

	/*
	 * 1. Input(s): String
	 *  Output : int
	 *  Constraint(s):
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :Brute Force
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input="abcbcbb";
		Assert.assertTrue(findLongestSubStringUsingAscii(input)==3);
	}


	@Test
	public void testData02() { // Negative
		String input="aaaa";
		Assert.assertTrue(findLongestSubStringUsingAscii(input)==1);
	}

	@Test
	public void testData03() { // Edge
		String input="pwwkew";
		Assert.assertTrue(findLongestSubStringUsingMap(input)==3);
	}

	private int findLongestSubString(String input) {
		int max=0;
		for (int i = 0; i < input.length()-1; i++) {
			String subArray =String.valueOf(input.charAt(i));
			for (int j = i+1; j <input.length(); j++) {
				if(subArray.contains(String.valueOf(input.charAt(j)))) {
					max=Math.max(max, subArray.length());
					subArray="";
					break;
				}else
				{
					subArray+=String.valueOf(input.charAt(j));
				}
			}		
		}
		return max;
	}

	private int findLongestSubStringUsingMap(String input) {
		int max=0,left=0,right=1;
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for (right = 1; right < input.length(); right++) {
			if(!map.containsKey(input.charAt(right))) {
				map.put(input.charAt(right), 1);
				max=Math.max(max, map.size());
			}
			else map.remove(input.charAt(left++));		
		}
		return max;
	}
	
	/*
	 * Pseudocode:
	 * 1) Initialise ascii array
	 * 2) 
	 * 
	 * 
	 */
	
	private int findLongestSubStringUsingAscii(String input) {
		int max=0,left=0;
		int[] ascii = new int[26];
		for (int right = 0; right < input.length(); right++) {
		   ascii[input.charAt(right)-'a']++;
		   while(ascii[input.charAt(right)-'a']>1)
			   ascii[input.charAt(left++)-'a']--;
		   max=Math.max(max, right-left+1);
		   
		}
		return max;
	}
}
