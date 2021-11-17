package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindMissingNumber {
	/*
	 * Problem Statement Input: nums = [3,0,1] Output: 2 Explanation: n = 3 since
	 * there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing
	 * number in the range since it does not appear in nums.
	 * 
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
		int[] nums= {9,6,4,2,3,5,7,0,1};
		Assert.assertTrue(missingNumberUsingHash(nums)==8);
	}
	
	@Test
	public void testData02() { // Positive
		int[] nums= {3,0,1};
		Assert.assertTrue(missingNumberUsingHash(nums)==2);
	}

	
	//TC -> On(log n)
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i) return i;		
		}
		return -1;	      
    }
	
	public int missingNumberUsingHash(int[] nums) {
		Set<Integer> set= new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);		
		}
		for (int i = 0; i < nums.length; i++) {
			if(!set.contains(i)) 
				return i;
		}	
		return nums.length;	      
    }
}
