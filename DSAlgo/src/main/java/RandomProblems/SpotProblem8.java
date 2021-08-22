package RandomProblems;

import org.junit.Test;

import junit.framework.Assert;

public class SpotProblem8 {
	/*
	 * Problem Statement Count the number of strictly increasing subarray of a
	 * specified size k in an array of size N . Example 1: int[] nums = [ 5,3,5,7,8]
	 * and k=3 , The answer is 2 as [3,5,7] and [5,7,8] are the sub arrays. Example
	 * 2: int[] nums = [ 5,3,5,7,8] and k=2 , The answer is 3 as [3,5] and [5,7] and
	 * [7,8] are the sub arrays.
	 * 
	 */

	/*
	 * 1. Input(s):integer array, integer Output :integer Constraint(s):No Constraint
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
		int[] nums= {5,3,5,7,8};
		int k=3;
		Assert.assertTrue(findIncreasingSubArray(nums,k)==2);
	}

	@Test
	public void testData02() { // Negative
		int[] nums= {5,3,5,7,8};
		int k=2;
		Assert.assertTrue(findIncreasingSubArray(nums,k)==3);
	}

	@Test
	public void testData03() { // Edge
		int[] nums= {5,2,1,4,2};
		int k=3;
		Assert.assertTrue(findIncreasingSubArray(nums,k)==0);
	}

	@Test
	public void testData04() { // Edge
		int[] nums= {1,2,3,6,1,2,3};
		int k=2;
		Assert.assertTrue(findIncreasingSubArray(nums,k)==5);
	}


	private int findIncreasingSubArray(int[] nums, int k) {
		int left=0,counter=0;
		while(left<nums.length) {
			int right=left+1,index=left;
			while(right<nums.length) {
				if(nums[index]<nums[right] && (right-left)<=k) {
					right++;
					index++;
				}
				else break;
				if(right-left == k) {
					counter++;
					index++;
				}
			}
			left++;
		}
		System.out.println(counter);
		return counter;
	}


}
