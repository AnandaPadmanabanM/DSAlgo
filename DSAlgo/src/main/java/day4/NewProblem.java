package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NewProblem {

	/*
	 * Given as integer array, move all the odd numbers to the right
	 * 
	 * Input:
	 * int[] input= {3, 2, 1, 6}
	 * 
	 * output:
	 * int[] output ={2, 6, 3, 1}
	 *
	 * 
	 * 
	 * 
	 */
	@Test //positive case
	public void tc01(){
		int[] input = {3, 4, 7};
		Assert.assertTrue(Arrays.equals(moveOddValuestoRightUsingPointer(input), new int[] {4, 3, 7} ));

	}

	@Test //negative case
	public void tc02(){
		int[] input = {7, 5 ,7};
		Assert.assertTrue(Arrays.equals(moveOddValuestoRightUsingPointer(input), new int[] {7, 5, 7} ));

	}

	@Test //edge case
	public void tc03(){
		int[] input = {4, 3, 7, 4};
		Assert.assertTrue(Arrays.equals(moveOddValuestoRightUsingPointer(input), new int[] {4, 4, 7, 3} ));

	}

	/*Pseudocode:
	 *  Initialise lists to store the odd values & even values
	 * 1) Iterate through the input array
	 * 2) Check for odd or even using mod operator
	 * 3) If odd, move it to the oddlist
	 * 4) If even, move it to the even list
	 * 5) Merge the list
	 * 6) Return as array
	 * 
	 * Complexity:
	 * Time -> O(n)
	 * Space -> O(n)
	 *  
	 */

	private int[] moveOddValuestoRight(int[] input) {
		List<Integer> oddList = new ArrayList<>();
		List<Integer> evenList = new ArrayList<>();
		List<Integer> mergeList = new ArrayList<>();

		for(int i=0;i<input.length;i++) {
			if(input[i]%2 == 1) oddList.add(input[i]);
			else evenList.add(input[i]);
		}
		mergeList.addAll(evenList);
		mergeList.addAll(oddList);				
		int[] output = new int[mergeList.size()];		
		for (int i = 0; i < mergeList.size(); i++) output[i] = mergeList.get(i);	
		System.out.println(Arrays.toString(output));
		return output;
	}


	private int[] moveOddValuestoRightUsingPointer(int[] input) {

		int left=0, right=input.length-1;
		while(left<right) {
			if(input[left]%2 ==0) left++;			
			else if(input[right]%2 ==1) right--;
			else if(input[left]%2 !=0 && input[right]%2 != 1) {
				int temp = input[left];
				input[left++]=input[right];
				input[right--] = temp;
			}	
		}
		
		System.out.println(Arrays.toString(input));
		return input;	
	}
}
