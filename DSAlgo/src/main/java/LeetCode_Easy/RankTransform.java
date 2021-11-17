package LeetCode_Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class RankTransform {
	/*
			Problem Statement
			
			1331. Rank Transform of an Array
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
		int[] arr= {37,12,28,9,100,56,80,5,12};
		doRankTransform(arr);
	}

	private int[] doRankTransform(int[] arr) {
		 	Map<Integer,Integer> map=new HashMap<>();
	        int[] dup=Arrays.copyOf(arr, arr.length);       
	        Arrays.sort(arr);
	        int temp=1; 
	        for(int i=1;i<=arr.length;i++){
	            if(!map.containsKey(arr[i-1])) {
	                map.put(arr[i-1],temp++); 
	            } 
	        }            
	 //       int[] out=new int[arr.length];
	        for(int i=0;i<arr.length;i++){
	            arr[i]= map.get(dup[i]);
	        }    
	        System.out.println(Arrays.toString(arr));
	        return arr;
	}

	
}
