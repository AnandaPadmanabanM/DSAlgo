package LeetCode_Easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class FindNumberofWordsTyped {
	/*
			Problem Statement
			
			1935. Maximum Number of Words You Can Type
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
			1) Initialize set and add broken characters in it
			2) Convert given text to the array based on white spaces
			3) Iterate through each String and traverse through each character
			4) If set contains character, increment the count
			5) Return the difference between string array and count
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String text = "hello world";
		String brokenLetters = "ad";
		Assert.assertTrue(findNumberofWordsTyped(text,brokenLetters)==1);
	}

	private int findNumberofWordsTyped(String text,String brokenLetters) {
		 Set<Character> set = new HashSet<>();
	        int left=0;
	        int count=0;
	        while(left<brokenLetters.length())
	            set.add(brokenLetters.charAt(left++));        
	        String[] eachText=text.split(" ");
	        for(String input:eachText){
	            for(left=0;left<input.length();left++){
	                 if(set.contains(input.charAt(left))) {
	                     count++;
	                     break;
	                 }
	            }        
	        }
	        return eachText.length-count;
	}
	

	
}
