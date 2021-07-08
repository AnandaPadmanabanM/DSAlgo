package day2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindMissingElement {
	/*
	 * Given an array nums containing n distinct numbers in the range [0, n], return the 
	 * only number in the range that is missing from the array.
   Input: nums = [3,0,1]
   Output: 2
	 * 	
	 * 1. Did I understand the problem? Yes
        If no ask the person to provide with more details with examples
        If yes go to the next step
        What is the input(s)? int[]
        What is the expected output?  int 
        Do I’ve constraints to solve the problem? Dont use additional DS
        Do Ive all the information to go to the next steps 
        How big is your test data set will be? 

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions
3. Do I know to solve it?
        Yes- great is there an alternate ? Yes 
        No - can I break the problem into sub problems?
4. Ask for hint (if you don't know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know
        1. Using summation and find difference in sum
        2. Sort the array and find the difference between each should be 1
Simple technique brute force
6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- O(N)
        Approach 2: O(N) + O(N) => O(N
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it
	 */

	@Test
	public void test1() {
		int[] data = { 0, 3, 1};
		Assert.assertTrue(findMissingElementUsingSort(data) == 2);

	}

	@Test
	public void test2() {
		int[] data = { 0,1,2,3};
		Assert.assertTrue(findMissingElementUsingSort(data) == -1);
	}


	@Test
	public void test3() {
		int[] data = { 0 };
		Assert.assertTrue(findMissingElementUsingSort(data) == 1);

	}

	@Test
	public void test4() {
		int[] data = { 1 };
		Assert.assertTrue(findMissingElementUsingSort(data) == 0);

	}

	@Test
	public void test5() {
		int[] data = { 3 };
		Assert.assertTrue(findMissingElementUsingSort(data) == -1);

	}

	/* Pseudocode
	 *   	1. Check if input is empty array return -1
	 *   	2. If input length is 1, then check for the element
	 *      	a) if element is zero, return 1
	 *     		b) if element is one, return  0
	 * 		3. Initialize variable min, max, actualSum
	 * 		4. Iterate the given input
	 *   		 Find min,max and actualSum
	 * 		5. Find the expected sum by formulae n(length of input)  * (n +1) div by 2
	 * 		6. Find the diff between actualSum and expectedSum
	 *    		if Max is greater than length of array then return invalid input
	 *    		if actualSum and expectedSum are equals and min is not equal to zero return 0
	 *    		if difference if between min and max value return the diff
	 *    
	 *  Time  - O(N)
	 *  Space - O(1) 
	 */

	private int findMissingElementInArray(int[] nums) {
		int length = nums.length;
		if (length == 0)
			return 1;
		if (length == 1) {
			if (nums[0] == 1)
				return 0;
			else if (nums[0] == 0)
				return 1;
			else
				return -1;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int actualSum = 0;
		for (int i : nums) {
			actualSum += i;
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int expectedSum = (length * (length + 1)) >>1 ; // missing element = expectedSum - actualSum
		if (max > length)
			return -1;
		if (actualSum == expectedSum && min != 0)
			return 0;
		if (min < (expectedSum - actualSum) && (expectedSum - actualSum) < max)
			return expectedSum - actualSum;
		return -1;
	}

	/*Pseudocode
	 *   1. Check if input is empty array return -1
	 *   2. If input length is 1, then check for the element
	 *      	a) if element is zero, return 1
	 *     		b) if element is one, return  0
	 * 	 3. Sort the given array values
	 *   4. Iterate the input and return the index if it's greater than current value
	 *           
	 * Time : O(n) to O(n log(n))
	 * Space : O(1)
	 */



	private int findMissingElementUsingSort(int[] nums)
	{

		int length = nums.length;
		if (length == 0)
			return -1;
		if (length == 1) {
			if (nums[0] == 1)
				return 0;
			else if (nums[0] == 0)
				return 1;
			else
				return -1;
		}
		Arrays.sort(nums);	

		for (int i = 0; i < nums.length; i++)  //O(n)
		{
			if(nums[i]>i) return i;
		}
		return -1;	
	}


	

}