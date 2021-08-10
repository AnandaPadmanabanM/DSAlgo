package day7;

import org.junit.Assert;
import org.junit.Test;

public class Problem3 {
	/*
	 * Problem Statement Problem 1) Alex and Lee play a game with piles of stones.
	 * There are an even number of piles arranged in a row, and each pile has a
	 * positive integer number of stones piles[i].
	 * 
	 * The objective of the game is to end with the most stones. The total number of
	 * stones is odd, so there are no ties.
	 * 
	 * Alex and Lee take turns, with Alex starting first. Each turn, a player takes
	 * the entire pile of stones from either the beginning or the end of the row.
	 * This continues until there are no more piles left, at which point the person
	 * with the most stones wins.
	 * 
	 * Assuming Alex and Lee play optimally, return True if and only if Alex wins
	 * the game.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: piles = [5,3,4,5] Output: true Explanation: Alex starts first, and can
	 * only take the first 5 or the last 5. Say he takes the first 5, so that the
	 * row becomes [3, 4, 5]. If Lee takes 3, then the board is [4, 5], and Alex
	 * takes 5 to win with 10 points. If Lee takes the last 5, then the board is [3,
	 * 4], and Alex takes 4 to win with 9 points. This demonstrated that taking the
	 * first 5 was a winning move for Alex, so we return true.
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
		int[] nums= {8,9,7,9};
		Assert.assertTrue(findWinner(nums)==true);
	}

	@Test
	public void testData02() { // Negative
		int[] nums= {6,9,4,3,9,8}; //,,4,3,9,8
		Assert.assertTrue(findWinner(nums)==true);
	}

	@Test
	public void testData03() { // Edge
		int[] nums= {1,2,23,3};
		Assert.assertTrue(findWinner(nums)==true);
	}

	@Test
	public void testData04() { // Edge
		int[] nums= {7,8,8,10};
		Assert.assertTrue(findWinner(nums)==true);
	} 

	@Test
	public void testData05() { // Edge
		int[] nums= {8,9,7,6,7,6}; 
		Assert.assertTrue(findWinner(nums)==true);
	} 


	private boolean findWinner(int[] nums) {
		 int round=1,sum1=0,sum2=0,left=0,right=nums.length-1;
			while(left<=right) {
				if(round%2==1) {
					if((nums[left]>nums[right] && nums[left]> nums[right-1]) || nums[left+1]<nums[right-1]) {
						sum1+=nums[left++];
						round++;
					}else {
						sum1+=nums[right--];
						round++;
					}
				}else {
					if(nums[left]>nums[right]  || left==right ||nums[left+1]<=nums[right-1] ) {
						sum2+=nums[left++];
						round++;
					}else {
						sum2+=nums[right--];
						round++;
					}
				}
			}

			if(sum1>sum2) return true;

			return false;
	}

	//	public boolean containsNearbyDuplicate(int[] nums, int k) {
	//        for(int i=0;i<nums.length;i++){
	//             for(int j=i+1;j<nums.length;j++){
	//                 if(nums[i]==nums[j] && Math.abs(i-j) <=k)
	//                     return true;
	//             }
	//        }
	//        return false;
	//    }
	//
	//
	//    public boolean containsNearbyDuplicate(int[] nums, int k) {
	//        int left=0, right=1;
	//        
	//        while(left<nums.length){
	//        while(right<nums.length){
	//            if(nums[left] == nums[right] && Math.abs(right-left) <=k) return true;
	//            else right++;
	//        }
	//            left++;
	//            right=left+1;
	//        }
	//        return false;
	//    }
	//
	//
	//public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	//         for(int i=0;i<nums.length;i++){
	//             for(int j=i+1;j<nums.length;j++){
	//                 if(Math.abs(nums[i]-nums[j])<= t && Math.abs(i-j) <=k)
	//                     return true;
	//             }
	//        }
	//        return false;
	//    }


}
