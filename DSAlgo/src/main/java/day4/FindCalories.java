package day4;

import org.junit.Test;

import junit.framework.Assert;

public class FindCalories {
	
	
	/*1) A dieter consumes calories[i] calories on the i-th day. For every consecutive sequence of k days, they look at T, the total calories consumed during that sequence of k days:

If T < lower, they performed poorly on their diet and lose 1 point;
If T > upper, they performed well on their diet and gain 1 point;
Otherwise, they performed normally and there is no change in points.
Return the total number of points the dieter has after all calories.length days.

Note that: The total points could be negative.

Example 1:
Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3  -1,-1,0,1,1 
Output: 0  
Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.

Example 2:
Input: calories = [3,2], k = 2, lower = 0, upper = 1
Output: 1
Explaination: calories[0] + calories[1] > upper, total points = 1.

Example 3:
Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5 
Output: 0
Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.



1) Intput -> calories, k, lower, upper
2) Output -> Integer
3) Constraint -> Sliding window

Test data:
positive -> calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3 
negative -> calories = [1,2,3,4,5], k = 6, lower = 3, upper = 3 
negative -> calories = [], k = 1, lower = 3, upper = 3 
edge-> calories = [0,0,0,0], k = 2, lower = 0, upper = 0 

	Pseudocode:  [1,2,3,4,5]  k=2 , i
	1) Initialise totalCalories & sum as zero
	2) Iterate through the array till K and find sum
	3) Compare sum with lower 
		if sum is less than lower, then add -1 to the totalCalories
		if sum is greater than upper, then add 1 to the totalCalories
	4)Iterate through the array from k to the length-k
	5) Remove the first index and add Kth index value and find sum
	6) Compare sum with lower 
		if sum is less than lower, then add -1 to the totalCalories
		if sum is greater than upper, then add 1 to the totalCalories
	7) Return totalCalories

	 * 
	 * 
	 * 
	 */
	
//@SuppressWarnings("deprecation")
//@Test //positive
//public void tc01() {
//	
//	int[] calories = {2,2,1,3,1,1};
//	int k = 2, lower=3, upper=3;
//	Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 1);
//}
//
//@SuppressWarnings("deprecation")
//@Test //negative
//public void tc02() {
//	
//	int[] calories = {1,2,3,4,5};
//	int k = 6, lower=3, upper=3;
//	Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
//}
//
//@SuppressWarnings("deprecation")
//@Test //edge
//public void tc03() {
//	
//	int[] calories = {0,0,0,0};
//	int k = 2, lower=0, upper=0;
//	Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
//}
//
//@SuppressWarnings("deprecation")
//@Test //edge
//public void tc04() {
//	
//	int[] calories = {};
//	int k = 1, lower=3, upper=3;
//	Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
//}
//{2,2,1,3,1,1};
	
	@Test
	public void testData01() // Positive
	{
		int[] calories = {1,2,3,4,5}; 
		int k = 1, lower = 3, upper = 3;
		Assert.assertTrue(findTotalCalories(calories,k,lower,upper) == 0);
	}
	
	@Test
	public void testData02() // Edge
	{
		int[] calories = {3,2}; 
		int k = 2, lower = 2, upper = 3;
		Assert.assertTrue(findTotalCalories(calories,k,lower,upper) == 1);
	}
	
	@Test
	public void testData03() // Edge
	{
		int[] calories = {-1,1,0,2,-2,0}; 
		int k = 1, lower = -1, upper = 1;
		Assert.assertTrue(findTotalCalories(calories,k,lower,upper) == 0);
	}
	
	@Test
	public void testData04() // Edge
	{
		int[] calories = {2,3,-4,5,6,-6,9,-9,1}; 
		int k = 3, lower = 1, upper = 5;
		Assert.assertTrue(findTotalCalories(calories,k,lower,upper) == 0);
	}
	
	@Test
	public void testData05() // Edge
	{
		int[] calories = {6,5,0,0}; 
		int k = 2, lower = 1, upper = 5;
		Assert.assertTrue(findTotalCalories(calories,k,lower,upper) == 0);
	}
	
	private int findTotalCalories(int[] calories, int k, int lower, int upper) {
		if(calories.length<k || calories.length==0) throw new RuntimeException("Invalid Input");
		int totalCalories=0, sum=0;
		for (int i = 0; i < k; i++) sum+=calories[i];
		if(sum<lower) totalCalories+=-1;
		else if(sum>upper)totalCalories+=1;
		
		sum=0;
		for (int i = k; i <= calories.length-k; i+=k) {
			sum+=calories[i]+calories[i+1];
			if(sum<lower) totalCalories+=-1;
			else if(sum>upper)totalCalories+=1;
			sum=0;
		}	
		System.out.println(totalCalories);
		return totalCalories;
	}

}
