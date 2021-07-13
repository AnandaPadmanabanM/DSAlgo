package day1;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class FindFirstDuplicate {
	/*
	 * 1)	Did I understand the problem? Yes or No !! 
	 * 		-> If No, Ask the person to provide more detail with example(s) 
	 * 		-> If yes, go to next step !! 
	 * 
	 *  
	 *  What is the input(s)? 
	 *  What is the expected output? 
	 *  Do I have constraints to solve the problem? 
	 *  Do I have all informations to go to next step!! 
	 *  How big is your test data set will be?
	 * 
	 *  
	 *  2) Test Data Set
	 *   	-> Positive, Negative, Edge
	 *   
	 *  3)DO I know to solve it?
	 *   	-> Yes- check for alternate solution
	 *   	-> No - Check for feasibility to break down into sub problems
	 *   
	 *  4)Ask for hint
	 *  
	 *  5)Do I know alternate solutions?
	 *  	-> Yes - what are those?
	 *  	-> No - it's okay to proceed with what you know 
	 * 	
	 * 
	 * Approach Taken:
	 * 	1) Yes	 	
	 *  2) positive -> i/p {3,5,4,4,8,8}  o/p ->4
	 *     negative -> i/p-> {3,5,6,4,8} or {} what we need to return?
	 *     edge -> i/p-> {1,1,1,3,4} 
	 *  3) yes  
	 *  4) Not required
	 *  5) Brute force
	 *   
	 */

	@Test
  public void tc1() {
	  int[] nums= {3,8,4,8,4,8,8};
	  Integer n =8;
	  Assert.assertEquals(findFirstDup(nums),n);
  }
	
	@Test
	  public void tc2() {
		  int[] nums= {3,8,4,-7};
		  Integer n =-1;
		  Assert.assertEquals(findFirstDup(nums),n);
	  }


	private Integer findFirstDup(int[] nums) {
		 
		Set<Integer> set = new HashSet<>();
		int i =0;
		for ( i = 0; i < nums.length; i++) {
			
			if (!set.add(nums[i])) return nums[i];
		}
		
		return -1;
	}
	

}