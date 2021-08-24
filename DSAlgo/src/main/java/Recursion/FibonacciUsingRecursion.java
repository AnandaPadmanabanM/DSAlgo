package Recursion;

import org.junit.Test;

public class FibonacciUsingRecursion {
	/*
			Problem Statement
			
			Fibonnaci Series Using Recursion
			 0 1 1 2 3 5 8
		*/

	/*
	   1. Identify base case -> 0, 1
	   2. Have test data -> 8
	   3. Have edge case  -> 1
	   4. Logic has to be identified -> n + fibonacci(n-1)
	   5. 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		
	 System.out.println(findFibonacci(6));
	
	}
	
	private int findFibonacci(int n) {
		//
		if(n==0 ) return 0;
		if(n==1) return 1;
		int k = findFibonacci(n-1) + findFibonacci(n-2);	
		return k;
	}
	
	
}
