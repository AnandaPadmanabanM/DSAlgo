package LeetCode_Easy;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FIndDIString {
	/*
	 * Problem Statement
	 * 
	 * 942. DI String Match
	 */

	/*
	 * 1. Input(s): String Output : int[] Constraint(s): 2 pointer
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode: 
	 * 1) Initilaize left =0, right=s.length, out[] with string
	 * length+1 
	 * 2) Iterate through the given String
	 * 3) If character == I, assign out[i]=left else right 
	 * 4) increment left and right depends on the situation 
	 * 5) if left==right, 
	 * 5)return out
	 * 
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "IDID";
		Assert.assertTrue(Arrays.equals(findDIString(s), new int[] { 0, 4, 1,3,2}));
	}

	@Test
	public void testData02() { // Negative
		String s = "III";
		Assert.assertTrue(Arrays.equals(findDIString(s), new int[] { 0, 1, 2, 3 }));
	}

	@Test
	public void testData03() { // Edge
		String s = "DDI";
		Assert.assertTrue(Arrays.equals(findDIString(s), new int[] { 3, 2, 0, 1 }));
	}

	private int[] findDIString(String s) {
		int[] out = new int [s.length()+1];
		int left=0,right=s.length();
		for(int i=0;i<=s.length();i++){
			if(left==right) {
				out[i]=right;
				break;
			}
			if(s.charAt(i)=='I' ) out[i]=left++;
			else {
				out[i]=right--;
			}
		}
		return out;
	}
}
