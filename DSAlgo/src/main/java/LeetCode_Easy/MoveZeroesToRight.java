package LeetCode_Easy;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;



public class MoveZeroesToRight {
	/*
			Problem Statement
			Leetcode 283. Move Zeroes
	 */

	/*
	   1. 
	  	  Input(s):int[]
		  Output :int[]
		  Constraint(s):less than O(n^2)

	   2. Test data
			Positive : 
			Negative :	
			Edge     :

	   3.  Approaches Known 
			 Approach : Two Pointer Equi directional

	   4.  O - Notation 
	   			Time -O(n)
	   			Space- O(1)


	   5.  Pseudocode
	   		1)Initialize left=0, right=1
	   		2)Iterate through the array and check for below conditions
	   		 	a)if value of left is not equal to zero and value of right =0, increment left
	   		 	b)if value of left is equal to zero and value of right =0, then swap the values and increment left 
	   		 	c) if value of left is not equal to zero and value of right !=0, increment left
	   		3) Increment right for all conditions 
	   		4)Return input
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] nums= {1,0,2,3,0,8};
		Assert.assertTrue(Arrays.equals(moveZeroesToRight(nums),new int[] {1,2,3,8,0,0}));

	}

	@Test
	public void testData02() { // Negative
		int[] nums= {1,1,2,3,1,8};
		Assert.assertTrue(Arrays.equals(moveZeroesToRight(nums),new int[] {1,1,2,3,1,8}));
	}

	@Test
	public void testData03() { // Edge
		int[] nums= {0};
		Assert.assertTrue(Arrays.equals(moveZeroesToRight(nums),new int[] {0}));
	}

	private int[] moveZeroesToRight(int[] nums) {
		int left=0,right=1;
		if(nums.length==1) return nums;
		while(right<=nums.length-1) {
			if(nums[left]==0 && nums[right] !=0) {
				int temp=nums[left];
				nums[left]=nums[right];
				nums[right]=temp;
				left++;
			}else if(nums[left]!=0 && nums[right] ==0) left++;
			else if(nums[left]!=0 && nums[right] !=0) left++;
			right++;
		}
		return nums;		
	}
}
