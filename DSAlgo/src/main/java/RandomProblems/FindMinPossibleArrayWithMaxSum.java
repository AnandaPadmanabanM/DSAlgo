package RandomProblems;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindMinPossibleArrayWithMaxSum {
	/*
	 * Problem Statement
	 * 
	 * Given an array of integers, return the minimum possible contiguous array with
	 * maximum sum value. Examples: int[] nums = {2,4,-11,0,3,7} Output {3,7}
	 * Explanation: Sum of 3+7 is the biggest sum of all elements in the array.
	 * Though 0+3+7 gives the same value, it is expected to return the min possible
	 * contiguous array, hence it is {3,7}
	 */

	/*
	 * 1. Input(s): Output : Constraint(s):
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] nums= {2,4,-11,0,3,7};
		Assert.assertTrue(Arrays.equals(findMinArrayWithMaxSum(nums),new int[] {3,7}));
	}
	
	@Test
	public void testData02() { // Positive
		int[] nums= {1,4,11,-1,3,7};
		Assert.assertTrue(Arrays.equals(findMinArrayWithMaxSum(nums),new int[] {1,4,11,-1,3,7}));
	}
	
	@Test
	public void testData03() { // Positive
		int[] nums= {1,4,1,-9,3,1};
		Assert.assertTrue(Arrays.equals(findMinArrayWithMaxSum(nums),new int[] {1,4,1}));
	}
	
	private int[] findMinArrayWithMaxSum(int[] nums) {
		int windowSum=nums[0], maxSum=nums[0], startIndex=0, endIndex=0,j=0,prewindowSum=0;
		for(int i=1;i<=nums.length;i++) {
			if(windowSum>prewindowSum) {
			prewindowSum =windowSum;
			endIndex=i;
			} 
			if(i == nums.length) break;
			windowSum+=nums[i];
			if(windowSum<=0 ) {
				windowSum=0;
				j=i+1;
			}
			if(windowSum>maxSum) {
				maxSum=windowSum;
				startIndex=j;
			}
		}	
		return Arrays.copyOfRange(nums, startIndex, endIndex);
	}

}
