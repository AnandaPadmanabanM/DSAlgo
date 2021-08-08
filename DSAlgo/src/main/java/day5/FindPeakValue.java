package day5;

import java.util.Arrays;

import org.junit.Test;

public class FindPeakValue {
	
	/*
	 * A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
	 * 
	 * 
	 * 1,2,1,3,5,6,4
	 * 
	 */
	
	@Test
	public void tc01() {
		int[] input= {1,2,1,3,5,6,4};
		System.out.println(findIndex(input));
		
	}
	
	@Test
	public void tc02() {
		int[] input= {1,-2,1,-7};
		System.out.println(findIndex(input));
		
	}
	
	@Test
	public void tc03() {
		int[] input= {1,2,1,3,5,6,7};
		System.out.println(findIndex(input));
		
	}
	
	private int findIndex(int[] input) {
		int low=0,high=input.length-1,mid=0;
	//	Arrays.sort(input);
		while(low<high) {
			mid=(low+high)/2;
			if(input[mid]>input[mid+1]) high=mid;
			else low=mid+1 ;		
		}		
		return low;
	}

}
