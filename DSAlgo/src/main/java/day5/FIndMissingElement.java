package day5;

import org.junit.Test;

public class FIndMissingElement {

	
	/*P2) Given an array arr of positive integers sorted in a strictly increasing order, and an integer k. Find the kth positive integer that is missing from this array.
 
Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
	 * 
	 * 
	 * 
	 */
	
	
	
	@Test
	public void tc01() {
		int[] input= {2,3,4,7,11};
		System.out.println(findMissingUingBinary(input,5));		
	}
	
	@Test
	public void tc02() {
		int[] input= {2,3,4,7,11};
		System.out.println(findMissingUingBinary(input,4));		
	}
	
/*Pseudocode:
 * 1) Initialise low, mid and missing as zero and high as length
 * 2) Find midvalue 
 * 3) Compare till low > high 
 * 4) Find missing value by subtracting value of mid with the index mid +1
 * 5) Check if missing < target value 
 * 		If yes, low =mid+1
 * 		else, high =mid-1;
 * 6) Find missing value by subtracting value of high with the index high +1
 * 7)Return missing value by adding value of high + (Target -missing elements)
 * 
 * 
 * 	
 */
	
	private int findMissingUingBinary(int[] input, int k) {
		int low=0, high=input.length-1, mid=0, missing=0;
		while(low<=high) {
			mid=(low+high)/2;
			missing = input[mid]-(mid + 1);
			if (missing < k) low  = mid + 1;    
			else high = mid -1 ;
		}	
		if (high < 0)	return k;
		missing=input[high]-(high + 1);
		return input[high] + (k - missing);
	}
}
