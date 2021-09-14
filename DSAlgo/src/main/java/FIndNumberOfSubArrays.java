import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

public class FIndNumberOfSubArrays {
	/*
	 * Problem Statement Problem 2:
	 * 
	 * Given an array of integers nums and an integer k, return the total number of
	 * continuous subarrays whose sum equals to k.   Example 1:
	 * 
	 * Input: nums = [1,1,1], k = 2 Output: 2
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,2,3], k = 3 Output: 2
	 * 
	 */

	/*
	 * 1. Input(s): Output : Constraint(s):
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :
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
		int[] nums = {1,1,1};
		int k =2;
		Assert.assertTrue(findNumberOfSubArraysUsingPointer(nums,k)==2);
	}

	@Test
	public void testData02() { // Positive
		int[] nums = {1,2,3};
		int k =3;
		Assert.assertTrue(findNumberOfSubArraysUsingPointer(nums,k)==2);
	}

	@Test
	public void testData03() { // Positive
		int[] nums = {1,1,3};
		int k =3;
		Assert.assertTrue(findNumberOfSubArraysUsingPointer(nums,k)==1);
	}

	private int findNumberOfSubArrays(int[] nums, int k) {
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			int currentSum = nums[i];
			if(currentSum == k) {
				count++;
				continue;
			}
			for (int j = i+1; j < nums.length; j++) {
				currentSum+=nums[j];
				if(currentSum == k) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	/*Pseudocode:
	 * 1) Initialise pointers left=0, right =1
	 * 2) 
	 * 
	 * 
	 */

	private int findNumberOfSubArraysUsingPointer(int[] nums, int k) {
		if(nums.length==0) return -1;
		int count=0, left=0,right=1,currentSum=nums[0];
		while(left<nums.length) {
			if(currentSum ==k) {
				count++;
				currentSum-=nums[left++];
			} 
			if(currentSum <k && right< nums.length) {
				currentSum+=nums[right++];
			}
			
			if(currentSum >k) {
				currentSum=nums[left];
			}
		}	
		return count;
	}
}
