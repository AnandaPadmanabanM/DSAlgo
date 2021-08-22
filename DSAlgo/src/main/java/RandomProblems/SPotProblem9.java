package RandomProblems;

import org.junit.Test;

import junit.framework.Assert;

public class SPotProblem9 {
	/*
	 * Problem Statement
	 * 
	 * Question 4: You are given a string s and an integer k, a k duplicate removal
	 * consists of choosing k adjacent and equal letters from s and removing them,
	 * causing the left and the right side of the deleted substring to concatenate
	 * together. We repeatedly make k duplicate removals on s until we no longer
	 * can. Return the final string after all such duplicate removals have been
	 * made. It is guaranteed that the answer is unique.   Example 1: Input: s =
	 * "abcd", k = 2 Output: "abcd" Explanation: There's nothing to delete. Example
	 * 2: Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
	 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
	 * "ddd", get "aa" Example 3: Input: s = "pbbcggttciiippooaais", k = 2 Output:
	 * "ps"
	 */

	/*
	 * 1. Input(s): Output : Constraint(s):
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach :
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode
	 * 1. Initialise boolean with false 
	 * 2. Iterate the given string with consectuive k length is present, we hhave to update make boolean as true
	 * 			-concatenate the string with the input
	 * 3. If boolean is false, return input string //base 
	 * 4. call recursively
	 * 
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "deeedbbcccbdaa";
		int k=3;
		System.out.println(findString(input,k));
		Assert.assertTrue(findString(input,k).equals("aa"));
		
	}

	@Test
	public void testData02() { // Negative
		String input = "abcd";
		int k=5;
		System.out.println(findString(input,k));
		Assert.assertTrue(findString(input,k).equals("abcd"));

	}

	@Test
	public void testData03() { // Edge
		String input = "abcddd";
		int k=3;
		System.out.println(findString(input,k));
		Assert.assertTrue(findString(input,k).equals("abc"));
	}
	
	@Test
	public void testData04() { // Edge
		String input = "pbbcggttciiippooaais";
		int k=2;
		System.out.println(findString(input,k));
		Assert.assertTrue(findString(input,k).equals("ps"));
	}
	
	@Test
	public void testData05() { // Edge
		String input = "cabdddbettteeb";
		int k=3;
		System.out.println(findString(input,k));
		Assert.assertTrue(findString(input,k).equals("ca"));
	}
	
	private String findString(String input, int k) {		
		boolean flag=false;
		if(k>input.length()) return input;
		for (int i = 0; i <= input.length()-k; i++) {
			int counter=1;
			for (int j = i+1; j < i+k; j++) {
				if(input.charAt(i)!=input.charAt(j)) break;
				else counter++;
				if(counter ==k) {
					input=input.replaceFirst(input.substring(i, j+1),"");
					flag=true;					
				}
			}	
		}
		if(!flag) return input;				
		return findString(input,k);
		
	}
		
}
