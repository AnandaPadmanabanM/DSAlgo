package LeetCode_Easy;

import org.junit.Test;

import junit.framework.Assert;

public class FindValidPalindrome {
	/*
			Problem Statement
			125. Valid Palindrome
			
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
			 Approach : Two Pointer
	
	   4.  O - Notation TC -O(n),SC - O(n)
			  
	
	   5.  Pseudocode
	    1) Initialise string and pointers as left=0, right=string length-1
	    2) Check for alphanumeric and concatenate the input characters
	    3) Traverse through the concatenated string and return false if left != right
	    4)   else return true	
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "A man, a plan, a canal: Panama";
		Assert.assertTrue(findPalindrome(s)==true);
	}

	private boolean findPalindrome(String s) {
		 String out="";
	        int left=0;
	        while(left<s.length()){
	        if(Character.isLetterOrDigit(s.charAt(left))) out+=s.charAt(left);
	            left++;
	        }
	        out=out.toLowerCase();
	        System.out.println(out);
	        left=0;
	        int right=out.length()-1;
	        while(left<=right){
	            if(out.charAt(left)!=out.charAt(right)) return false;
	            left++;
	            right--;
	        } 
	        return true;
	}
}
