package HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class FindSubArrayWithoutDuplicate {
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
		int[] nums= {1,2,1,3,2};
		int k=2;
		Assert.assertTrue(Arrays.equals(findMaxSubArrayWithoutDup(nums,k), new int[] {2,1,3,2}));
	}
	
	@Test
	public void testData02() { // Positive
		int[] nums= {1,2,1,3,2};
		int k=1;
		Assert.assertTrue(Arrays.equals(findMaxSubArrayWithoutDup(nums,k), new int[] {1,2,1,3,2}));
	}
	
	@Test
	public void testData03() { // Positive
		int[] nums= {1,2,1,3,2,2};
		int k=2;
		Assert.assertTrue(Arrays.equals(findMaxSubArrayWithoutDup(nums,k), new int[] {2,1,3,2}));
	}

	private int[] findMaxSubArrayWithoutDup(int[] nums, int k) {
		int left=0,right=0;
		int startIndex=0,endIndex=0;
		Map<Integer,Integer> map = new HashMap<>();
		for(right=0; right<=k; right++){
			map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
		}
		
		while(left<nums.length-k) {
			if(map.size() < k+1 && right-left>=k) {
				if(map.get(nums[left])>1) {
					map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
				}else map.remove(nums[left]);
				startIndex++;
			}
			left++;
			if(right<nums.length) map.put(nums[right], map.getOrDefault(nums[right++], 0)+1);
			else break;
		}	
		return Arrays.copyOfRange(nums, startIndex, right);
	}

}
