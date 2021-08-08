package BSProblems;

import org.junit.Assert;
import org.junit.Test;

public class FindOccurenceofTarget {

	/*
	 * Given a sorted array find the number of ones in the array
	 * [0,1,1,1,1,1] output = 5
	 * [0,0,0,0,0] output = 0
	 * [0,0,0,0,0,1] output = 1
	 * 
	 * 
	 * Pseudocode:
	 * 1) Initialise low=0 and high as length-1
	 * 2) Find the mid value of the array
	 * 3) Iterate till low crosses high
	 * 4) Check if mid value of the array is greater than the target, then high=mid-1
	 * 		else low=mid+1
	 * 5)
	 */

	@Test
	public void tc01() {
		int[] nums= {0,1,1,1,1};
		int k =1;
//		Assert.assertTrue(findnumberofOnes(nums,k)==4);
		Assert.assertTrue(findnumberofOnesUsingPointer(nums,k)==4);
	}
	
	@Test
	public void tc02() {
		int[] nums= {0,0,0};
		int k =1;
//		Assert.assertTrue(findnumberofOnes(nums,k)==0);
		Assert.assertTrue(findnumberofOnesUsingPointer(nums,k)==0);
	}
	
	@Test
	public void tc03() {
		int[] nums= {1,1,1};
		int k =1;
//		Assert.assertTrue(findnumberofOnes(nums,k)==3);
		Assert.assertTrue(findnumberofOnesUsingPointer(nums,k)==3);
	}

	private int findnumberofOnes(int[] nums, int k) {

		int low=0,high=nums.length-1,mid=0;
		while(low<=high) {
			mid=(low+high)/2;
			if(nums[mid]==1 && mid-1<0) return nums.length-mid;
			if(nums[mid]==1 && nums[mid-1]==0) return nums.length-mid;
			if(nums[mid]==0) low=mid+1;
					else high=mid-1;
		}

		return nums.length-low;

	}
	
	private int findnumberofOnesUsingPointer(int[] nums, int k) {

		int left=0,right=nums.length-1;
		while(left<=right) {
			if(nums[left]==1) return nums.length-left;
			if(nums[right]==0) return nums.length-right-1;
			left++;
			right--;
		}

		return 0;

	}

}
