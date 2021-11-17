package ClassRoom;

import org.junit.Test;

import junit.framework.Assert;

public class FIndMaxSumWithSameDigits {
	/*
			Problem Statement
			Palo Alto Network Question - 3
			
		*/

	/*
	   1. 
	  	  Input(s):
		  Output :
		  Constraint(s):
	   
	   2. Test data
			Positive : 
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : Hashing
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode	
	    1) Implement the logic to find sum of the given individual integer by using % and / operator by 10
	    2) Initialize the array and add sum to it
	    3) Find the indices of the matching sum and calculate the original sum with the given input
	    4) Calculate the max value and return it.
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] nums= {51,71,17,42};
		Assert.assertTrue(findMaxSum(nums)==93);
		System.out.println(findMaxSum(nums));
	}

	@Test
	public void testData02() { // Negative
		int[] nums= {42,33,60};
		Assert.assertTrue(findMaxSum(nums)==102);
		System.out.println(findMaxSum(nums));
	}

	@Test
	public void testData03() { // Edge
		int[] nums= {51,32,43};
		Assert.assertTrue(findMaxSum(nums)==-1);
		System.out.println(findMaxSum(nums));
	}
	
	@Test
	public void testData04() { // Edge
		int[] nums= {51,34,43};
		Assert.assertTrue(findMaxSum(nums)==77);
		System.out.println(findMaxSum(nums));
	}
	
	public int findIntegerSum(int input) {
		int digit=0, sum=0;
		while(input>0) {
			digit=input%10;
			sum+=digit;
			input=input/10;
		}		
		return sum;		
	}
	
	private int findMaxSum(int[] nums) {
		int maxSum=0;
		int[] intSum= new int[nums.length];
		int left=0;
		while(left<nums.length) {
			intSum[left] =findIntegerSum(nums[left]);
			left++;
		}
		left=0;
		int right=left+1;
		while(left<nums.length-1 && right<nums.length ) {
			if(intSum[left] == intSum[right]) {
				int currentSum=nums[left]+nums[right];
				maxSum=Math.max(maxSum, currentSum);
			}	
			if(right==nums.length-1) {
				left++;
				right=left+1;
			}else right++;
		}	
		return maxSum>0?maxSum:-1;
	}
	
}
