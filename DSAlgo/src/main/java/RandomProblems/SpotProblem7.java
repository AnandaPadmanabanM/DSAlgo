package RandomProblems;

import org.junit.Test;

public class SpotProblem7 {
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
		int[] height= {1,2,0,3,2};
		trap(height);
	}

	//@Test
	public void testData02() { // Negative
		
	}

	//@Test
	public void testData03() { // Edge
		
	}
	
	 public int trap(int[] height) {
	        // time : O(n)
	        // space : O(1)
	        if (height.length==0) return 0; 
	        int left = 0, right = height.length-1; 
	        int leftMax=0, rightMax=0; 
	        int ans = 0; 
	        while (left < right) {
	            if (height[left] > leftMax) leftMax = height[left]; 
	            if (height[right] > rightMax) rightMax = height[right];
	            if (leftMax < rightMax) {
	                ans += Math.max(0, leftMax-height[left]); 
	                left++; 
	            } else {
	                ans += Math.max(0, rightMax-height[right]); 
	                right--; 
	            }
	        }
	        System.out.println(ans);
	        return ans; 
	    }
}
