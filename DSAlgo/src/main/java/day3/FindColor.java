package day3;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class FindColor {

	/*
	 * Given an array nums with n objects colored red, white, or blue, sort them
	 * in-place so that objects of the same color are adjacent, with the colors in
	 * the order red, white, and blue.
	 * 
	 * We will use the integers 0, 1, and 2 to represent the color red, white, and
	 * blue, respectively.
	 * 
	 * You must solve this problem without using the library's sort function.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,0,2,1,1,0] chars[white]<=2 && chars[blue]<=2 Output:
	 * [0,0,1,1,2,2]
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [2,0,1] Output: [0,1,2]
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [0] Output: [0]
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
			if (sumOfSquares == 1)
				return true;
			if (!set.add(sumOfSquares))
				return false;
			n = sumOfSquares;
			sumOfSquares = 0;
		} while (n != 1);

		return false;
	}

}
