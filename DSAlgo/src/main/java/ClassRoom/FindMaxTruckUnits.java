package ClassRoom;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindMaxTruckUnits {
	/*
	 * Problem Statement You are assigned to put some amount of boxes onto one
	 * truck. You are given a 2D array boxTypes, where boxTypes[i] =
	 * [numberOfBoxesi, numberOfUnitsPerBoxi]:
	 * 
	 * numberOfBoxesi is the number of boxes of type i. numberOfUnitsPerBoxi is the
	 * number of units in each box of the type i. You are also given an integer
	 * truckSize, which is the maximum number of boxes that can be put on the truck.
	 * You can choose any boxes to put on the truck as long as the number of boxes
	 * does not exceed truckSize.
	 * 
	 * Return the maximum total number of units that can be put on the truck.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4 Output: 8 Explanation:
	 * There are: - 1 box of the first type that contains 3 units. - 2 boxes of the
	 * second type that contain 2 units each. - 3 boxes of the third type that
	 * contain 1 unit each. You can take all the boxes of the first and second
	 * types, and one box of the third type. The total number of units will be = (1
	 * * 3) + (2 * 2) + (1 * 1) = 8. Example 2:
	 * 
	 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10 Output: 91
	 * 
	 */

	/*
	 * Input(s): int[][], int
	 * Output : int
	 * Constraint(s): 
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :Brute Force
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode
	 * 	1) Sort the given input by number of units in descending order
	 *  2) Initialize the noOfUnits=0, noOfBoxes=0;
	 *  3) Iterate through the values and check for the number of boxes with the given truck size
	 *  4) Check If number of boxes is less than truck size, then multiply boxes * no of Units and add  it to the noOfUnits
	 *  5) If noOfBoxes>= trucksize, return the noOfUnits
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[][] nums= {{1,3}, {2,2}, {3,1}};
		int size=4;
		Assert.assertTrue(findMaxTruckUnits(nums,size)== 8);
	}

	@Test
	public void testData02() { // Edge
		int[][] nums= {{1,1}, {1,1}, {3,1}};
		int size=1;
		Assert.assertTrue(findMaxTruckUnits(nums,size)== 1);
	}

	private int findMaxTruckUnits(int[][] nums, int target) {
		int noOfUnits=0;
		Arrays.sort(nums,(a,b)->{
			if(a[0]!=b[0]) return a[0]-b[0]; //end
			else return a[1]-b[1]; //start
		});
		int noOfBoxes=nums[0][0];
		for (int i = 1; i < nums.length-1; i++) {
		    if(noOfBoxes<= target) {
		    	noOfBoxes+=nums[0][i];
		    	noOfUnits=noOfBoxes*nums[1][i];
		    }
		}
		return noOfUnits;
	}	
}
