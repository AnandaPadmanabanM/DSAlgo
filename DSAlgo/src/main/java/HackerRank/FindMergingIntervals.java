package HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class FindMergingIntervals {
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
		List<Integer> arr= Arrays.asList(1,2,3,4,5);
		List<List<Integer>> operations =Arrays.asList(Arrays.asList(1,3),Arrays.asList(2,3));
		performOperations(arr,operations);
	}

	@Test
	public void testData02() { // Negative
	
	}

	@Test
	public void testData03() { // Edge
		
	}
	
	public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
	    // Write your code here
	    for(int i=0;i<operations.size();i++){
	        
	        List<Integer> list = operations.get(i);
	        Collections.swap(arr, list.get(0), list.get(1));
	        
	    }  
	    System.out.println(arr);
	    return arr;
	    }
	
}
