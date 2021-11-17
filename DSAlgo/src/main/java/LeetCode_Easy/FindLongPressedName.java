package LeetCode_Easy;

import org.junit.Test;

import junit.framework.Assert;

public class FindLongPressedName {
	/*
			Problem Statement

			925. Long Pressed Name
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
		String name = "alex";
		String typed = "aaleex";
		Assert.assertTrue(findLongPressedName(name,typed)==true);
	}
	
	@Test
	public void testData02() { // Positive
		String name = "saeed";
		String typed = "ssaaedd";
		Assert.assertTrue(findLongPressedName(name,typed)==false);
	}

	private boolean findLongPressedName(String name, String typed) {
		int left=0;
		int right=0;
		int count=0;
		char prev=name.charAt(left);
		while(left<name.length() && right<typed.length()){
			if(name.charAt(left)==typed.charAt(right)){
				if(prev==typed.charAt(right)) right++;
				else return false;			
			}else if(name.charAt(left)!=typed.charAt(right)){
				left++;
				prev=name.charAt(left);
				
			}
		} 
		return true;   
	}
}
