package LeetCode_Easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class FindSumofUniqueElements {
	/*
			Problem Statement
			
			1748. Sum of Unique Elements
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
	   1) Initialise map and add input to it with the number of occurences
	   2) Iterate through the entryset and check if value == 1
	   		if yes, then add key to the sum
	   3) return sum
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] nums = {1,2,3,2};
		Assert.assertTrue(findSumOfUniqueElements(nums)==4);
	}

	private int findSumOfUniqueElements(int[] nums) {
		  Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	       int left=0;
	       int sum=0;
	       while(left<nums.length){
	          map.put(nums[left],map.getOrDefault(nums[left],0)+1);
	           left++;
	       }         
	       for(Map.Entry<Integer,Integer> entry:map.entrySet())
	           if(entry.getValue()==1) sum+=entry.getKey(); 
	        return sum;
	}

}
