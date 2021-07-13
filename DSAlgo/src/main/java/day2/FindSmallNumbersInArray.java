package day2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallNumbersInArray {


	/*
    7)Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Constraints:
2 <= nums.length <= 500
0 <= nums[i] <= 100

Example 1:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).


Problem solving template
1. Did I understand the problem? yes or no
        If no ask the person to provide with more details with examples
        If yes go to the next step
        What is the input(s)? Input array
        What is the expected output? Integer
        Do I’ve constraints to solve the problem? No
        Do Ive all the information to go to the next steps
        How big is your test data set will be?
2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions
3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?
4. Ask for hint (if you don’t know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know
Simple technique brute force
6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it


	Pseudocode:
	1)input = integer array
	2)output = integer array
	3)check for smallest element occurence for the current element in the array. 
	4)if found, increment the counter and add it to the array
	5)Return array 
	 *  
	 *  Complexity:
	 *  Time - O(n^2)
	 *  Space -O(n)
	 */


	@Test
	public void test1(){
		int[] nums={8,1,2,2,3};
		Assert.assertEquals(findSmallestNumbers(nums), new Integer[] {4,0,1,1,3});
	}
	
	@Test
	public void test2(){
		int[] nums={6,5,4,8};
		Assert.assertEquals(findSmallestNumbers(nums), new Integer[] {2,1,0,3});
	}
	
	@Test
	public void test3(){
		int[] nums={7,7,7,7};
		Assert.assertEquals(findSmallestNumbers(nums), new Integer[] {0,0,0,0});
	}
	
	private Integer[] findSmallestNumbers(int[] nums)
	{

		
		Integer[] output = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int count =0;
			for (int j = 0; j < nums.length; j++) {
				if(i != j && nums[i] > nums[j]) {
					count++;	
				}
				
			}
			output[i] = count;
		}
		return output ;
	}

}
