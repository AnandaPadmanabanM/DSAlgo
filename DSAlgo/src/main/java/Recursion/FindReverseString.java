package Recursion;

import java.util.Arrays;

import org.junit.Test;

public class FindReverseString {
	/*
			Problem Statement


	 */

	/*
	   1. Identify base case -> input.length == 0
	   2. Have test data -> 	"world" , " "
	   3. Have edge case  ->    "a"
	   4. Logic has to be identified -> 

	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input="World";
		System.out.println(findReverseString(input));
	}

	@Test
	public void testData02() { // Positive
		String input="Beauty";
		System.out.println(findReverseString(input));
	}
	
	@Test
	public void testData03() { // Edge
		String input="a b";
		System.out.println(findReverseString(input));
	}
	
	@Test
	public void testData04() { // Negative
		String input="";
		System.out.println(findReverseString(input));
	}


	StringBuilder out= new StringBuilder();

	private String findReverseString(String input) {	
		if(input.length()==0) return null;		
		out.append(input.charAt(input.length()-1));
		input=input.substring(0, input.length()-1);
		findReverseString(input);
		return out.toString();
	}


}
