package LeetCode_Medium;

import java.util.Iterator;

import org.junit.Test;

public class EncodeString {
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
		String str = "wwaaabbbccc";
		System.out.println(encodeString(str));		
	
			//	Output - w3a3b3c3a1
	}

	private String encodeString(String str) {
		String out= "";
		int count=1;
		for (int i =1 ; i < str.length(); i++) {
			if(str.charAt(i-1)!=str.charAt(i)) {
				out+=str.charAt(i-1)+String.valueOf(count);
				count=0;
			}
			count++;
		}
		out+=str.charAt(str.length()-1)+String.valueOf(count);
		return out;
	}
}
