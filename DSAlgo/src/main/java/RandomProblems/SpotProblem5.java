package RandomProblems;

import java.util.TreeSet;

import org.junit.Test;

public class SpotProblem5 {
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
		int[] nums= {2,3,1};
		findThirdmax(nums);
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}

	private int findThirdmax(int[] nums) {
		   TreeSet<Integer> tree = new TreeSet<Integer>();
	        for (int i : nums){
	            tree.add(i);
	        }  
	        
	        if (tree.size() == 2 || tree.size() == 1) {
	            return tree.last();
	        }
	        
	        tree.remove(tree.last());
	        tree.remove(tree.last());
	        return tree.last();
	}
}
