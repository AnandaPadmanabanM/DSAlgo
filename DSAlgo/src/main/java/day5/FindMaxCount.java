package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxCount {

	/*
	 * 
		Given an array of integers, return the highest sum of any consecutive elements in the array.
	 * 
	 * 
	 */
	@Test
	public void tc1() {
		int[] input = {1,-5,2,-3,7,1};		
	Assert.assertEquals(findMax(input), 8);
	}
	
	@Test
	public void tc2() {
		int[] input = {-1,-2,-4,-1};		
	Assert.assertEquals(findMax(input), -1);
	}
	
	
	private int findMax(int[] input) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			int sum=0;
			for(int j =i; j < input.length; j++) {
				sum+=input[j];				
			}			
			max= Math.max(max, sum);
		}
		System.out.println(max);
		return max;
	}

	
}
