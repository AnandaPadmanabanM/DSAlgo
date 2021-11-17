package LeetCode_Easy;

import org.junit.Test;

import junit.framework.Assert;

public class Retail_FindSumOfTwoDigits {
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
		int[] nums= {100,10,-2,-4,-18};
		Assert.assertTrue(findTwoSum(nums)==-8);
	}
	
	@Test
	public void testData02() { // Positive
		int[] nums= {100,-99,-9,-10};
		Assert.assertTrue(findTwoSum(nums)==-109);
	}
	
	@Test
	public void testData03() { // Positive
		int[] nums= {10,-99,9,99,100};
		Assert.assertTrue(findTwoSum(nums)==10);
	}

	private int findTwoSum(int[] A) {
		
		int sum=0;
		int ptr=0;
		while(ptr<A.length) {
			if(A[ptr]>9 && A[ptr]<100 || A[ptr]<-9 && A[ptr]>-100 ) {
				sum+= A[ptr];
			}		
			ptr++;
		}
		System.out.println(sum);
		return sum;	
		

	}

	}
