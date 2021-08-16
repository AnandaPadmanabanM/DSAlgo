package RandomProblems;

import org.junit.Test;

import junit.framework.Assert;

public class RandomSolutions {
	/*
			Problem Statement


	 */

	/*
	   1. 
	  	  Input(s):
		  Output :
		  Constraint(s):

	   2. Test data
			Positive : 
			Negative :	
			Edge     :

	   3.  Approaches Known 
			 Approach : 

	   4.  O - Notation 


	   5.  Pseudocode		

	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] height = {1,8,6,2,5,4,8,3,7};
		maxArea(height);

	}
	
	@Test
	public void testData02() { // Positive
		int[] height = {1,1};
		maxArea(height);

	}

	public int maxArea(int[] height) {
		int max=0;
		for(int i=0;i<height.length;i++){

			for(int j=i+1;j<height.length;j++){
				max=Math.max(max,Math.min(height[i],height[j])*(j-i));
			}
		}
		System.out.println(max);
		return max;
	}
}
