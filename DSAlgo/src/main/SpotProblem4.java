package RandomProblems;

import org.junit.Test;

public class SpotProblem4 {
	/*
	 * Problem Statement You are given a floating-point number hour, representing
	 * the amount of time you have to reach the office. To commute to the office,
	 * you must take n trains in sequential order. You are also given an integer
	 * array dist of length n, where dist[i] describes the distance (in kilometers)
	 * of the ith train ride.
	 * 
	 * Each train can only depart at an integer hour, so you may need to wait in
	 * between each train ride.
	 * 
	 * For example, if the 1st train ride takes 1.5 hours, you must wait for an
	 * additional 0.5 hours before you can depart on the 2nd train ride at the 2
	 * hour mark. Return the minimum positive integer speed (in kilometers per hour)
	 * that all the trains must travel at for you to reach the office on time, or -1
	 * if it is impossible to be on time.
	 * 
	 * Tests are generated such that the answer will not exceed 107 and hour will
	 * have at most two digits after the decimal point.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: dist = [1,3,2], hour = 6 Output: 1 Explanation: At speed 1: - The
	 * first train ride takes 1/1 = 1 hour. - Since we are already at an integer
	 * hour, we depart immediately at the 1 hour mark. The second train takes 3/1 =
	 * 3 hours. - Since we are already at an integer hour, we depart immediately at
	 * the 4 hour mark. The third train takes 2/1 = 2 hours. - You will arrive at
	 * exactly the 6 hour mark.
	 * 
	 */

	/*
	 * 1. Input(s):Integer array, int Output :int  Constraint(s): No
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode
	 * /*
	* Pseudo code - Binary Search
	* Round off the hour value and assign it to range
	* If range is less than train's length, return -1
	* Initialize low as 1, high as range
	* Traverse low <= high
	* Find mid & Initialize sum as 0
	* Traverse through the array until length - 1
	* Divide each element by mid and assign it to temp
	* Round off temp to next nearest integer and add it to the sum
	* Divide the last digit with mid and add it to the sum
	* If the sum == hour, return mid
	* If sum < high, high = mid-1
	* else low = mid+1
	* Return -1
*/
	 

	// Test data(s)
	@Test
	public void testData01() { // Positive
	 int[] input= {1,3,2};
	 double hour=6;
	}

	@Test
	public void testData02() { // Negative
		
	}

	@Test
	public void testData03() { // Edge
		
	}
	
	private int findHour(int[] input, double hour) {
		
		
		return 0;	
	}
}
