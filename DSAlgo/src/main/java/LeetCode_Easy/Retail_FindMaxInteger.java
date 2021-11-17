package LeetCode_Easy;

import org.junit.Test;

import junit.framework.Assert;

public class Retail_FindMaxInteger {
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
		int n=512; int k=10;
		Assert.assertTrue(findMaxValue(n,k)==972);
	}
	
	@Test
	public void testData02() { // Positive
		int n=191; int k=4;
		Assert.assertTrue(findMaxValue(n,k)==591);
	}
	
	@Test
	public void testData03() { // Positive
		int n=285; int k=20;
		Assert.assertTrue(findMaxValue(n,k)==999);
	}

	private int findMaxValue(int n, int k) {
		int ones= n%10;
		n=n/10;
		int tens= n%10;
		n=n/10;
		int hundreds= n%10;
		while(k>0) {
			if(hundreds<9) {
				hundreds++;
				k--;
			}else if(tens<9) {
				tens++;
				k--;
			}else if(ones<9) {
				ones++;
				k--;
			}else break;		

		}
		return Integer.parseInt(String.valueOf(hundreds)+String.valueOf(tens)+String.valueOf(ones));
	}


}
