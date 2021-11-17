package LeetCode_Easy;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class CheckforPanagram {
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
		String sentence = "thequickbrownfoxjumpsoverthelazydog";
		Assert.assertTrue(checkPanagram(sentence)==true);
	}
	@Test
	public void testData02() { // Negative
		String sentence = "thequickzydog";
		Assert.assertTrue(checkPanagram(sentence)==false);
	}

	private boolean checkPanagram(String sentence) {
		int[] ascii= new int[26];
		int left=0;
		while(left<sentence.length()) {
			ascii[sentence.charAt(left++)-'a']++;
		}
		left=0;
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		while(left<alphabet.length()) {
			if(ascii[alphabet.charAt(left++)-'a'] < 1) return false;
		}	
		

		return true;
	}


}
