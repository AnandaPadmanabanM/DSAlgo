package Recursion;

import java.util.Arrays;

import org.junit.Test;

public class FindOneOcuurence {
	/*
		
			Problem 2: The input is integer and examples are 1010 … 1111
			
		*/

	/*
	   1. Identify base case -> nums.length <= 0
	   2. Have test data -> 	{0,1,1,0,0,1}
	   3. Have edge case  ->     {0,0,0,0}
	   4. Logic has to be identified ->
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		
		int nums= 1001001;
		System.out.println(findNumbersofOnes(nums));
		
	}
	
	@Test
	public void testData02() { // Positive
		
		int nums= 0001;
		System.out.println(findNumbersofOnes(nums));
		
	}
	
	@Test
	public void testData03() { // Positive
		
		int nums= 1111;
		System.out.println(findNumbersofOnes(nums));
		
	}
	
	@Test
	public void testData04() { // Positive
		
		int nums= 000;
		System.out.println(findNumbersofOnes(nums));
		
	}
	int count =0;
	private int findNumbersofOnes(int nums) {
	    if(nums <= 0) return 0;
		if(nums%10 != 0) {
			count++;
		}	
		findNumbersofOnes(nums/10);
		return count;
	}

	
}
