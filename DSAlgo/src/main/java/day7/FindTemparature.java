package day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class FindTemparature {

	/*
	 * Given an array of integers temperatures represents the daily temperatures,
	 * return an array answer such that answer[i] is the number of days you have to
	 * wait after the ith day to get a warmer temperature. If there is no future day
	 * for which this is possible, keep answer[i] == 0 instead.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
	 * 
	 * 
	 * Input - String Output- int Constraints- no constraints
	 * 
	 * 2. Test data set
	 * 
	 * Positive : Negative : Edge :
	 * 
	 * 3. Solution Approach:
	 * 
	 * 4. O-Notation:
	 * 
	 * 5. Pseudocode: 1) if the length of the input, target
	 * 
	 */

	@Test
	public void testData01() // positive
	{
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		Assert.assertTrue(Arrays.equals(dailyTemperatures(temperatures), new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }));
	}

	@Test
	public void testData02() // negative
	{
		int[] temperatures = { 55, 38, -53, 81, 61, 93, 97, 32, 43, 78 };
		Assert.assertTrue(Arrays.equals(dailyTemperatures(temperatures), new int[] { 3, 2, 1, 2, 1, 1, 0, 1, 1, 0 }));
	}

	@Test
	public void testData03() // negative
	{
		int[] temperatures = { 9, 8, 7, 6, 5 };
		Assert.assertTrue(Arrays.equals(dailyTemperatures(temperatures), new int[] { 0, 0, 0, 0, 0 }));
	}

	@Test
	public void testData04() // edge
	{
		int[] temperatures = { 5, 5, 5 };
		Assert.assertTrue(Arrays.equals(dailyTemperatures(temperatures), new int[] { 0, 0, 0 }));
	}

	@Test
	public void testData05() // edge
	{
		int[] temperatures = {};
		Assert.assertTrue(Arrays.equals(dailyTemperatures(temperatures), new int[] {}));
	}

	private int[] dailyTemperatures(int[] temperatures) {
		int[] out = new int[temperatures.length];
		int count = 0;
		for (int i = 0; i < temperatures.length - 1; i++) {
			for (int j = i + 1; j <= temperatures.length - 1; j++) {
				if (temperatures[j] > temperatures[i]) {
					out[count] = j - i;
					count++;
					break;
				} else if (j == temperatures.length - 1) {
					out[count] = 0;
					count++;
				}
			}
		}
		System.out.println(Arrays.toString(out));
		return out;
	}
	
	private int[] dailyTemperaturesUsingSliding(int[] temperatures) {
		int[] out = new int[temperatures.length];
		int count = 0;
		for (int i = 0; i < temperatures.length - 1; i++) {
			for (int j = i + 1; j <= temperatures.length - 1; j++) {
				if (temperatures[j] > temperatures[i]) {
					out[count] = j - i;
					count++;
					break;
				} else if (j == temperatures.length - 1) {
					out[count] = 0;
					count++;
				}
			}
		}
		System.out.println(Arrays.toString(out));
		return out;
	}
		
}



