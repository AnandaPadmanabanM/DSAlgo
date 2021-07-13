package day2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindIncrementedIntger {


	/*
    6) Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
Example 1:
Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

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
	2)output = integer
	3)check for (i+1) element in the array. if found, increment the counter
	4)return the counter
	 *  
	 *  Complexity:
	 *  Time - O(n^2)
	 *  Space -O(n)
	 */


	@Test
	public void test1(){
		int[] nums={3,1,2};
		Integer count= 2;
		Assert.assertEquals(findTargetvalue(nums), count);
	}
	

	@Test
	public void test2(){
		int[] nums={1,1,3,3,5,5,7,7};
		Integer count= 0;
		Assert.assertEquals(findTargetvalue(nums), count);
	}

	@Test
	public void test3(){
		int[] nums={1,3,2,3,5,0};
		Integer count= 3;
		Assert.assertEquals(findTargetvalue(nums), count);
	}

	@Test
	public void test4(){
		int[] nums={1,1,2,2};
		Integer count= 2;
		Assert.assertEquals(findTargetvalue(nums), count);
	}

	@Test
	public void test5(){
		int[] nums={1,1,2};
		Integer count= 2;
		Assert.assertEquals(findTargetvalue(nums), count);
	}

	private Integer findTargetvalue(int[] nums)
	{
		if(nums.length == 0) return -1;

//		Arrays.sort(nums); [1,3,2,3,5,0] [1,1,2]

		int count =0;
		int index =0;
		for (int i = 0; i < nums.length; i++) {
			int temp =  nums[i] +1;
			for (int j = 0; j < nums.length; j++) {
				if(i != j && temp == nums[j]) {
					count++;
					break;
				}
					
			}

		}
		boolean letter = Character.isLetter('9');
		System.out.println(letter);

		return count;
	}
	
	private Integer findTargetvalueusingList(int[] nums)
	{
		if(nums.length == 0) return -1;

		int count =0;
		int index =0;
		for (int i = 0; i < nums.length; i++) {
			int temp =  nums[i] +1;
			for (int j = 0; j < nums.length; j++) {
				if(i != j && temp == nums[j]) {
					count++;
					break;
				}
					
			}

		}
		
		return count;
		
	}

}
