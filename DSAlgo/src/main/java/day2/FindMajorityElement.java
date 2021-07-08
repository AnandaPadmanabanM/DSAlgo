package day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindMajorityElement {

	/*
    Que - Given an array nums of size n, return the majority element. ou may assume that the majority element always exists in the array.The majority element is the element that appears more than ⌊n / 2⌋ times.
1. Did I understand the problem? yes
        If no ask the person to provide with more details with examples
        If yes go to the next step
        What is the input(s)? --> Integer array of size n
        What is the expected output?  --> integer
        Do I’ve constraints to solve the problem?  --> Yes
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

  Constraints:No Sort, No Extra Space
	 * Pseudo code:  
	 *  1. Check for input length and handle it
	 *  2. Store input with value as key and occurrence as pair in the hash map
	 *  3. Traverse through the map with key value
	 *  4. Verify if occurrence of the element is greater than n/2
	 *  5. If yes, return the value else zero.
	 *  
	 *  Complexity:
	 *  Time - O(n^2)
	 *  Space - O(n)
	 *  
	 */	


	@Test
	public void test1() {
		int[] nums = {2, 6, 2, 2,6};
		Integer n=2;
		Assert.assertEquals(findMaxOccurrence(nums),n);
	}

	@Test
	public void test2() {
		int[] nums = {1, 2, 2, 2, 4, 6,};
		Integer n=2;
		Assert.assertEquals(findMaxOccurrence(nums),n);
	}

	@Test
	public void test3() {
		int[] nums = {};
		Integer n=0;
		Assert.assertEquals(findMaxOccurrence(nums),n);
	}


	public Integer findMajorElement(int[] nums) 
	{

		if (nums.length==0) throw new IllegalArgumentException("Invalid Input");

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
		{
			
			Integer value = entry.getValue();

			if (value >nums.length/2) 
			{
				return entry.getKey();
			}

		}

		return 0;
	}
	
	
	
	
//	  Constraints:No Sort, No Extra Space 
//	Pseudo code:
//		1. Check for input length and handle it // NA
//		2. Store input with value as key and occurrence as pair in the hash map 
//		3. Verify if occurrence of the element is greater than n/2 
//		4. If yes, return the value else zero.	
//	Complexity:
//		 *  Time - O(n)
//		 *  Space - O(n)
	
	
	public Integer findMaxOccurrence1(int[] nums)
	{
				
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			
			if(map.get(nums[i])> nums.length >> 1)
			{
				return nums[i];
			}
		}
			
		return 0;
		
	}
	
//	  Constraints:Sort, No Extra Space 
//	Pseudo code:
//		1. Check for input length and handle it // NA
//		2. Store input with value as key and occurrence as pair in the hash map 
//		3. Traverse through the map with key value 
//		4. Verify if occurrence of the element is greater than n/2 
//		5. If yes, return the value else zero.	
//	Complexity:
//		 *  Time - O(1)
//		 *  Space - O(n)
	
	
	private Integer findMaxOccurrence(int[] nums)
	{
	
		Arrays.sort(nums);
		
		int mid = nums.length >> 1;
		
		if(nums.length % 2 == 1) return nums[mid];
		
		else if (nums[mid]== nums[mid-1]) return nums[mid];
		
		throw new IllegalArgumentException("Invalid Input");
			
	}
		
}