package day3;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindUniqueElement {
	
	
	/*
	 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:
Input: nums = [2,2,1]  1 2 2
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

invalid - no priority
{2,2,2,2}
{1,2,3,3,4,4}
{}

constraint:-
constant space- O(1)
Time complexity- O(n)

bruteforce:-
O(n2)-- using two for loops

optimized:-

solutions 1
1. sort the array
2. initialize two pointers p1, p2 (p2<input.length-1)in equi directional
3. compare p1 and p2, if equal increment as p1=p2+1, p2=p1+1
4. else return p1

solutions 2
1. sort the array
2. iterate the array using pointer p1 from 0 to n
3. compare values of p1==p1+1, if equals increment p1 by 2
4. else return p1

1 2 2

	 * 
	 * 
	 * 
	 * 
	 * 
	 */


	@Test
	public void tc1(){
		int[] nums={2,2,1};
		Integer n=1;
		Assert.assertEquals(findUniqueElement(nums),n);
	}
	
	@Test
	public void tc2(){
		int[] nums={4,1,2,1,2};
		Integer n=4;
		Assert.assertEquals(findUniqueElement(nums),n);
	}
	
	@Test
	public void tc3(){
		int[] nums={1,-2,3,-2,4,4,3};
		Integer n=1;
		Assert.assertEquals(findUniqueElement(nums),n);
	}
	

	private Integer findUniqueElement(int[] nums) {
		
		Arrays.sort(nums);
		int i;
				
		for(i=0;i<nums.length-1;i+=2) {
			
			if(!(nums[i]==nums[i+1])) {
				
				return nums[i];
			}
			
		}		
		
		return nums[i];
		
	}
	
	
}
