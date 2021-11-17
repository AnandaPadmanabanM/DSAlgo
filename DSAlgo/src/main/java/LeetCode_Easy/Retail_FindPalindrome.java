package LeetCode_Easy;

import org.junit.Test;

import junit.framework.Assert;

public class Retail_FindPalindrome {
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
		String input="?ab??a";
		Assert.assertTrue(findPalindrome(input).equals("aabbaa"));
	}
	
	@Test
	public void testData02() { // Positive
		String input="bab??a";
		Assert.assertTrue(findPalindrome(input).equals("NO"));
	}
	
	@Test
	public void testData03() { // Positive
		String input="aa?aa";
		Assert.assertTrue(findPalindrome(input).equals("aaaaa"));
	}
	
	@Test
	public void testData04() { // Positive
		String input="?a?";
		Assert.assertTrue(findPalindrome(input).equals("aaa"));
	}

	private String findPalindrome(String input) {
		int left=0;
		int right=input.length()-1;
		char[] charArray = input.toCharArray();
		while(left<=right) {
			if(input.charAt(left)!='?' && input.charAt(right)!='?' && 
					input.charAt(left)== input.charAt(right) ) {
				left++;
				right--;
			}else if(input.charAt(left)=='?' && input.charAt(right)=='?') {
				charArray[left++] = 'a';
				charArray[right--] = 'a';
			}else if(input.charAt(left)=='?' && input.charAt(right)!='?'&&
					 Character.isLowerCase(input.charAt(right))) {
				charArray[left++] = charArray[right--];
			}else if(input.charAt(left)!='?' && input.charAt(right)=='?'&&
					Character.isLowerCase(input.charAt(left))) {
				charArray[right--] = charArray[left++];
			}
			else return new String("NO");
		}	
		return String.copyValueOf(charArray);
	}

	
}
