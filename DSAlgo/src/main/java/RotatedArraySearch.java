import org.junit.Test;

import junit.framework.Assert;

public class RotatedArraySearch {
	/*
	 * Problem Statement Q2 ) Search in a rotated array
	 * 
	 * 
	 * There is an integer array nums sorted in ascending order (with distinct
	 * values).
	 * 
	 * Prior to being passed to your function, nums is rotated at an unknown pivot
	 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
	 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
	 * example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become
	 * [4,5,6,7,0,1,2].
	 * 
	 * Given the array nums after the rotation and an integer target, return the
	 * index of target if it is in nums, or -1 if it is not in nums.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1 Example 3:
	 * 
	 * Input: nums = [1], target = 0 Output: -1
	 * 
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
		int[] nums= {4,5,6,7,0,1,2};
		int target =0;
		Assert.assertTrue(findRotatedArraySearch(nums,target) == 4);
	}

	@Test
	public void testData02() { // Negative
		int[] nums= {4,5,6,7,0,1,2};
		int target =3;
		Assert.assertTrue(findRotatedArraySearch(nums,target) == -1);
	}

	@Test
	public void testData03() { // Edge
		int[] nums= {1};
		int target =3;
		Assert.assertTrue(findRotatedArraySearch(nums,target) == -1);
	}

	private int findRotatedArraySearch(int[] nums, int target) {
		int low=0,high=nums.length-1, pivot=0;
		//Find Pivot
		if(nums.length==1 && nums[0]==target) return nums[0];
		else if(nums.length==1 && nums[0]!=target) return -1;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(nums[mid]> nums[mid-1] && nums[mid]>nums[mid+1]) {
				pivot=mid;
				break;
			}else if(nums[low]>nums[mid]) high=mid-1;
			else low=mid+1;			
		}	

		//Find Target
		low=0;
		high=nums.length-1;
		if(nums[pivot]==target) return pivot;
		if(nums[low]<target) high=pivot;
		else low=pivot+1;
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(nums[mid]==target) return mid;
			if(nums[low]>nums[mid]) low=mid+1;
			else high=mid-1;
		}
		return -1;
	}

}
