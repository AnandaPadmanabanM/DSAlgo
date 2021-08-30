package RandomProblems;

import org.junit.Assert;
import org.junit.Test;

public class SpotProblem3 {
	/*
	 * Problem Statement
	 * 
	 * Problem 1) Given an int array [1,4,20,3,10,5] and target sum 33. If target
	 * subarray sum is found, return true else false Time : 20 Minutes - Write
	 * another 2 test data (edge and neg) - Pseudo Code for Optimised Solution -
	 * Code, Debug - Time everything - Do it yourself !!
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
	 * 1) Initilaise two pointers with left, right =0
	 * 2) Iterate through the right pointer 
	 * 3) Add left and right pointer and check for target
	 * 4) If sum = target, return true
	 * 		- sum< target, then slide through the next input
	 * 		-sum > target, then increment left pointer
	 * 
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input= {1,33,20,3,10,5};
		int target = 33;
		Assert.assertTrue(findTargetSumUsing(input,target)==true);
	}

	@Test
	public void testData02() { // Negative
		int[] input= {1,4,20};
		int target = 70;
		Assert.assertTrue(findTargetSumUsing(input,target)==false);
	}

	@Test
	public void testData03() { // Edge
		int[] input= {1,2,2,1,3};
		int target = 3;
		Assert.assertTrue(findTargetSumUsing(input,target)==true);
	}
	
	private boolean findTargetSum(int[] input, int target) {
		//Initialise left & right pointers
		int left=0;
		while(left<input.length) {
			int sum =input[left];
			int right=left+1;
			while(right<input.length) {
				sum+=input[right++];
				if(sum == target) return true;
				else if(sum>target) break;
				else continue;
			}
			left++;
		}
		return false;		
	}
	
	private boolean findTargetSumUsing(int[] input, int target) {
		//Initialise left & right pointers
		int left=0;
		while(left<input.length) {
			int sum =0;
			int right=left;
			while(right<input.length) {
				sum+=input[right++];
				if(sum == target) return true;
				else if(sum>target) break;
				else continue;
			}
			left++;
		}
		return false;
		
	}

}
