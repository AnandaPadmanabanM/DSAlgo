package LeetCode_Easy;

import org.junit.Test;

import junit.framework.Assert;

public class FindHappyNumber {
	/*
			Problem Statement
			202. Happy Number
			
		*/

	/*
	   1. 
	  	  Input(s):Int
		  Output :boolean
		  Constraint(s):
	   
	   2. Test data
			Positive : 
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : 2 pointer
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode	
	    1. Find square of the sums by calculating quotient and remainder
	    2. Initialise 2 pointers with p1 = input, p2=input
	    3. Find square of sum for once using slow pointer p1 and return true if it's value is 1
	    4. Find square of sum for twice using fast pointer p2 and return true if it's value is 1
	    5. if value of p1 and p2 matches like pattern is getting repeated, then return false
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int input=19;
		Assert.assertTrue(findHappyNumber(input)==true);
	}

	@Test
	public void testData02() { // Negative
		int input=2;
		Assert.assertTrue(findHappyNumber(input)==false);
	}

	@Test
	public void testData03() { // Edge 26  40  16 37 58 89 145 42 20 4 16
		int input=15;
		Assert.assertTrue(findHappyNumber(input)==false);
	}
	
	@Test
	public void testData04() { // Edge 26  40  16 37 58 89 145 42 20 4 16
		int input=1;
		Assert.assertTrue(findHappyNumber(input)==true);
	}
	
	private int findSquareSum(int input) {
		int sum =0;
		int digit=0;
		while(input>0) {
			digit=input%10;
			sum+=digit*digit;
			input=input/10;
		}
		return sum;
	}
	
	public boolean findHappyNumber(int input) {
		int p1=input; int p2 =input;
		while(p2>1) {
			p1=findSquareSum(p1);
			if(p1==1) return true;
			
			p2=findSquareSum(p2);
			p2=findSquareSum(p2);
			if(p2==1) return true;
			
			if(p1==p2) return false;		
		}
		return true;
	}
		
		 
}
