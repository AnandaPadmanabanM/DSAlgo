package QueueProblems;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import junit.framework.Assert;

public class LongestContinuousSubArrUsingQueue {
	/*
	 * TASK: Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray 
	 * such that the absolute difference between any two elements of this subarray is less than or equal to limit.
	 * 
	        INPUT: int[], int
	        OUTPUT: int
	        CONSTRAINTS: Queue
	        TEST DATA:
	 */
	@Test
	public void test1() {
		int[] nums = {8,2,4,7};
		int limit = 4;
		Assert.assertEquals(2, findLongestContinuousSubArray(nums, limit));
	}

	@Test
	public void test2() {
		int[] nums = {4,2,2,2,4,4,2,2};
		int limit = 0;
		Assert.assertEquals(3, findLongestContinuousSubArray(nums, limit));
	}

	@Test
	public void test3() { //edge case
		int[] nums = {2,2,2,2};
		int limit = 0;
		Assert.assertEquals(4, findLongestContinuousSubArray(nums, limit));
	}

	@Test
	public void test4() { //negative case
		int[] nums = {5,7,10,14};
		int limit = 1;
		Assert.assertEquals(1, findLongestContinuousSubArray(nums, limit));
	}

	@Test
	public void test5() { //negative case
		int[] nums = {7,3,5};
		int limit = 5;
		Assert.assertEquals(3, findLongestContinuousSubArray(nums, limit));
	}
	
	@Test
	public void test6() { //negative case
		int[] nums = {1,5,6,7,8,10,6,5,6};
		int limit = 4;
		Assert.assertEquals(5, findLongestContinuousSubArray(nums, limit));
	}
	
	@Test
	public void test7() { //negative case
		int[] nums = {1,5,6,7,8,10,6,5,6};
		int limit = 4;
		Assert.assertEquals(10, findLongestContinuousSubArray(nums, limit));
		
	}
	
	

	/*
	 * Pseudocode:
	 * 1) Initialise the queue, max and min
	 * 2) Iterate through the array
	 * 		a) If nums[i]-nums[i+1] > limit, break the loop
	 * 		b) else add the elements to the queue 
	 * 3) Get the size of the queue and retain the max value
	 * 4) Return the max value
	 *      
	 */

	private int findLongestContinuousSubArray(int[] nums, int limit) {
		ArrayDeque<Integer> minQueue = new ArrayDeque<Integer> ();
		int left = 0, right = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int subArrayLength = Integer.MIN_VALUE;

		while(left < nums.length && right < nums.length) {
			// find the min and max for the absolute difference
			
			min = Math.min(min, Math.min(nums[left], nums[right]));
			max = Math.max(max, Math.max(nums[left], nums[right]));
			
			if(Math.abs(max-min) <= limit) {
				minQueue.offer(nums[right++]);
				subArrayLength= Math.max(subArrayLength, minQueue.size());			
			}else {
				right = ++left;
				minQueue.clear();
				min = nums[left];
				max = nums[left];
				
			}
		}
		return subArrayLength;
	}

	private int longestSubArray(int[] nums, int limit) {

		int left = 0, right = 0;
		int longest = Integer.MIN_VALUE, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		while(left < nums.length && right < nums.length) {

			// find the min and max for the absolute difference
			min = Math.min(min, Math.min(nums[left], nums[right]));
			max = Math.max(max, Math.max(nums[left], nums[right]));

			// Check with the limit
			if(Math.abs(max-min) <= limit) {
				longest = Math.max(longest, right-left+1);
				right++;
			} else {
				right = ++left;
				min = nums[left];
				max = nums[left];
			}

		}
		return longest;

	}
}



