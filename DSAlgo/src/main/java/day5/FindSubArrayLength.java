package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindSubArrayLength {

	/*
	 * Given a string s, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc",
	 * with the length of 3. Example 2: Input: s = "bbbbb" Output: 1 Explanation:
	 * The answer is "b", with the length of 1. Example 3: Input: s = "pwwkew"
	 * Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that
	 * the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * 
	 * 
	 * 
	 * 
	 */

	@Test
	public void tc1() {
		String input = "abcabcbb";
		Assert.assertEquals(findSubArrayCount(input), 3);
	}

	@Test
	public void tc2() {
		String input = "pwwkew";
		Assert.assertEquals(findSubArrayCount(input), 3);
	}

	private int findSubArrayCount(String input) {

		int left = 0, right = 0, max = Integer.MIN_VALUE;
		int[] charCount = new int[128];
		for (right = 0; right < input.length(); right++) {
			charCount[input.charAt(right)]++;
			while (charCount[input.charAt(right)] > 1) {
				max = Math.max(max, right - left);
				charCount[input.charAt(left++)]--;
			}
		}
		return max;
	}
}
