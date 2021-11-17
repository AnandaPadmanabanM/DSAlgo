package LeetCode_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FindTwoSum {
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
		int[] nums= {2,4,6,7,3,4};
		int target=8;
		System.out.println(findTwoSum(nums,target));
	
	}
	
	@Test
	public void testData02() { // Positive
		int[] nums= {2,4,6,7,3,4};
		int target=7;
		System.out.println(findTwoSum(nums,target));
	
	}
	
	@Test
	public void testData03() { // Positive
		int[] nums= {2,4,6,7,3,4};
		int target=10;
		System.out.println(findTwoSum(nums,target));
	
	}

	private List<List<Integer>> findTwoSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		List<List<Integer>> out = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = new ArrayList<>();
			int balance = target-nums[i];
			if(map.containsKey(balance)) {
				list.add(nums[map.get(balance)]);
				list.add(nums[i]);
				out.add(list);
			}else 
			map.put(nums[i], i);
		}		
		return out;
	}
	



}
