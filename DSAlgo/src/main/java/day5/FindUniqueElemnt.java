package day5;

import org.junit.Test;

public class FindUniqueElemnt {

	/*
	 * 
	 * You are given a sorted array consisting of only integers where every element
	 * appears exactly twice, except for one element which appears exactly once.
	 * Find this single element that appears only once. 
	 * Follow up: Your solution
	 * should run in O(log n) time and O(1) space.
		Example 1: Input: nums =
	 * [1,1,2,3,3,4,4,8,8] Output: 2 
	 * Example 2: Input: nums = [3,3,7,7,10,11,11]
	 * Output: 1
	 * 
	 * Test data
	 * 1,1,2,3,3,4,4,8,8 //mid =3
	 * 1,1,2,2,3,4,4,8,8
	 * 1,1,2,2,3,3,4,8,8
	 * Pseudocode:
	 * 1) Initialise low as zero, high as length -1
	 * 2) Iterate till low>high
	 * 3) Find mid and compare if mid != mid-1  && mid != mid+1, return mid
	 * 		  else mid != mid-1 && mid == mid+1, low= mid+2
	 * 					if (mid-low%2 !=0) then high=mid-1
	 * 				else mid == mid-1 && mid != mid=+1,high= mid-2
	 * 					if mid != mid-1  && mid != mid+1 return high
	 * 
	 */
	@Test
	public void tc01() {
		
		int[] data = {1,1,2,3,3,4,4,8,8};
		
		
	}
	
	
}
