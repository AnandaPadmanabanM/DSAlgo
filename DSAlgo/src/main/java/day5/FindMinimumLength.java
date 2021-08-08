package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindMinimumLength {

	
	/*
	 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 
	 * 
	 * 
	 */
	
	
	@Test
	public void tc1() {
		int[] input = {2,3,1,2,4,3};
		int target=7;
		Assert.assertEquals(findMinLength(input,target), 2);
	}
	@Test
	public void tc2() {
		int[] input = {2,3,1,2,4,3};
		int target=7;
		Assert.assertEquals(findMinLength(input,target), 2);
	}
	@Test
	public void tc3() {
		int[] input = {1,4,4};
		int target=4;
		Assert.assertEquals(findMinLength(input,target), 1);
	}
	@Test
	public void tc4() {
		int[] input = {2,3,1,2,4,3};
		int target=7;
		Assert.assertEquals(findMinLength(input,target), 2);
	}

	private int findMinLength(int[] input,int target) {
		
		int minLength=Integer.MAX_VALUE;		
		for (int i = 0; i < input.length; i++) {
				int sum=0;
			for (int j = i; j < input.length; j++) {
				sum+=input[j];
				if(sum>=target) {
					minLength=Math.min(minLength, j-i+1);
				}
			}
		}
				
		return minLength;
	}
	
	//Time complexity- O(n)
    //Space complexity- O(1)
    private int findMinLengthUsingPointer(int[] nums, int target) {
        if (nums.length == 0) return 0;
        boolean isTargetEverMet = false;
        if (nums.length == 1 && nums[0] >= target) return 1;
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                isTargetEverMet = true;
                sum -= nums[left++];
            }
            min = Math.min(min, right - left + 1);
        }
        if (!isTargetEverMet) return 0;
        return min;
    }
    
    
   
    

}
