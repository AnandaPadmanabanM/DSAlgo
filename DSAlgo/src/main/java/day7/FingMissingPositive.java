package day7;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FingMissingPositive {
	/*
			Problem Statement
			
			
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
			 Approach : 
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] nums= {-1,2,0,-8};
		Assert.assertTrue(firstMissingPositive(nums)==1);
	}
	
	@Test
	public void testData02() { // Positive
		int[] nums= {3,4,-1,1};
		Assert.assertTrue(firstMissingPositive(nums)==2);
	}
	
	@Test
	public void testData03() { // Positive
		int[] nums= {-1,-2,-60,40,43};
		Assert.assertTrue(firstMissingPositive(nums)==1);
	}

//	@Test
//	public void testData02() { // Negative
//		Assert.assertTrue();
//	}
//
//	@Test
//	public void testData03() { // Edge
//		Assert.assertTrue();
//	}
//	
	
	 public int firstMissingPositive(int[] nums) {
	        int swapCount=0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]<0 && i<nums.length-1 && nums[i+1]>=0){
	               int temp = nums[i];
	                nums[i]=nums[i+1];
	                nums[i+1]=temp;
	                swapCount++;
	            }
	        }
	        nums =Arrays.copyOfRange(nums, 0,nums.length-swapCount);
	        
	        for(int i=0;i<nums.length;i++){
	            if(i<nums.length-1 && nums[i]>nums[i+1]){
	               int temp = nums[i];
	                nums[i]=nums[i+1];
	                nums[i+1]=temp;
	            }
	        }
	        
	        int min = Integer.MAX_VALUE;
			int max = 0;
			int actualSum = 0;
			for (int i : nums) {
				actualSum += i;
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
			int expectedSum = (nums.length * (nums.length + 1)) / 2;
			
//			if (actualSum == expectedSum && min != 0)
//				return 0;
			if (min < (actualSum -expectedSum) && (actualSum -expectedSum) < max)
				return actualSum -expectedSum;
			if (max > nums.length)
				return 1;
			
			
			return max+1;
	    }
	 
}
