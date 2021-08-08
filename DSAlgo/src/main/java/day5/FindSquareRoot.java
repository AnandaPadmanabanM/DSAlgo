package day5;

import org.junit.Test;

public class FindSquareRoot {



	@Test
	public void tc01() {
		int data= 5;
		int  output = findSqrrootUsingBinary(data);
		System.out.println(output);

	}

	@Test
	public void tc02() {
		int data= 20;
		int  output = findSqrrootUsingBinary(data);
		System.out.println(output);	

	}

	@Test
	public void tc03() {
		int data= 67;
		int  output = findSqrrootUsingBinary(data);
		System.out.println(output);		
	}

	@Test
	public void tc04() {
		int data= 100;
		int  output = findSqrrootUsingBinary(data);
		System.out.println(output);		
	}



	/*
	 * Pseudocode:
	 * 1) Initiliase variable i=1
	 * 2) Find the square of i*i and compare with the target
	 * 3) Repeat till i*i > target, return i-1
	 * 
	 * 
	 * 18:
	 * 0, 18 -> mid =9 ->81
	 * 
	 * 0, 8 -> mid =4 ->16
	 * 
	 * 5, 8 -> mid =6 -> 36
	 * 
	 * return low-1
	 * 
	 * Binary Search:
	 * 1)Initialise low as zero and high as target
	 * 2) Find the mid  of low and high
	 * 3) Find square if mid and compare it with the target
	 * 4) if mid*mid>target, make low as mid+1
	 * 	else mid*mid<target, make high as mid-1
	 * 		else mid*mid=target, return mid value
	 * 5)Return high
	 * 
	 * 
	 */


	private int findSquareRoot(int input) {

		int i=1;
		while(i*i < input) {
			i++;
		}		
		return i-1;
	}


	private int findSqrrootUsingBinary(int input) {
		int low=1, high=input/2, mid=0;	
		while(low<=high) {
			mid=(low+high)/2;
			if(mid*mid== input) return mid;
			else if(mid*mid<input) low=mid+1;
			else high=mid-1 ;
		}		
		return high;
	}


	/*
	 * 2    4
	 * 
	 */

	private int findMissing(int[] arr, int k) {
		int missing = 0;
		int expected = 1;
		for(int i=0;i<arr.length;){
			if(arr[i]==expected){
				expected++;
				i++;
			}
			else{                       
				missing++;
				if(missing==k){
					break;
				}
				expected++;                
			}

		}

		if(missing<k){
			expected+=k-missing-1;
		}
		return expected;
	}


	private int findMissingUingBinary(int[] input, int k) {
		int low=0, high=input.length-1, mid=0, missing=0;
		while(low<=high) {
			mid=(low+high)/2;
			missing = input[mid]-(mid + 1);
			if (missing < k) low  = mid + 1;    
			else high = mid -1 ;
		}	
		if (high == -1)	return k;
		missing=input[high]-(high + 1);
		return input[high] + (k - missing);
	}
}
