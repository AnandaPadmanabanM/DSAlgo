package day3;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class FindHappyNumber {

	/*
	 * Write an algorithm to determine if a number n is happy. A happy number is a
	 * number defined by the following process:
	 * 
	 * Starting with any positive integer, replace the number by the sum of the
	 * squares of its digits. Repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1. Those
	 * numbers for which this process ends in 1 are happy. Return true if n is a
	 * happy number, and false if not.
	 * 
	 * Example 1:
	 * 
	 * Input: n = 19 1+81-->82 Output: true Explanation: 1^2 + 9^2 = 82 8^2 + 2^2 =
	 * 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
	 * 
	 * Example 2: Input: n = 2 Output: false'
	 * 
	 * 19 1+81-->82
	 * 
	 * 11--> 1 +1 2- 4 4-16 16-37 37- 9+49 58- 25+64 89- 64+81 145- 1+16+25 42- 16+4
	 * 20- 4+0 4-
	 * 
	 * Time complexity - O(n*m) space complexity- O(n) 
	 * solution 1 
	 * 1. initialize an	int variable sumOfsquares
	 * 2.for each digit in the inputNumber (using modulo)
	 * 		a.Compute the square (using ^) and add it to the sumOfsquares 
	 * 3. If sumOfsquares is 1 a.return true 
	 * 4. Repeat 2,3 till adding sumOfsquares to set is true (using do-while) 
	 * 5. return false
	 * 
	 * 
	 */

	@Test
	public void tc1() {
		int n = 19;
		Assert.assertEquals(findHappyNumber(n), true);
	}

	@Test
	public void tc2() {
		int n = 11;
		Assert.assertEquals(findHappyNumber(n), true);
	}


	private boolean findHappyNumber(int n) {
	        HashSet<Integer> set = new HashSet<>();
	        int sumOfSquares = 0;
	        do {	 
	            while (n != 0) {
	                int lastdigit = n % 10;
	                n /= 10;
	                lastdigit = lastdigit * lastdigit;
	                sumOfSquares += lastdigit;                	               
	            }
	            if(sumOfSquares ==1) return true;
	            if (!set.add(sumOfSquares)) return false;
	            n = sumOfSquares;
	            sumOfSquares=0;
	        } while (n != 1);

	        return false;
	    }

	
}
