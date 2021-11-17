package LeetCode_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class FindFrequencyIntegers {
	/*
			Problem Statement
			1636. Sort Array by Increasing Frequency

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
		int[] nums= {2,3,1,3,2};
		System.out.println(findFrequencyCharacters(nums));
	}

	private int[] findFrequencyCharacters(int[] nums) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			map.put(nums[i],map.getOrDefault(nums[i],0)+1);
		}
		int i=0,val=0;
		int[] out=new int[nums.length];
		int maxKey=Integer.MIN_VALUE;
		while(!map.isEmpty() && i<nums.length){
			maxKey=Integer.MIN_VALUE;
			int min=Collections.min(map.values());
			for(Map.Entry<Integer,Integer> entry:map.entrySet()){
				if(entry.getValue()==min){
					val=entry.getKey();
					maxKey=Math.max(maxKey, val);
				}
			}
			while(map.get(maxKey)>0) {
				out[i]=maxKey;
				i++;
				map.put(maxKey,map.getOrDefault(maxKey,0)-1);
			}
			map.remove(maxKey);
		}
		return out;	
	}
}
