package day7;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class RemoveAdjacentDuplicates {
	/*
	 * 
	 *Remove the adjacent duplicates in a string abbaaba = aba 
	 *abccba  = empty string
	 *  
	 *  input -> String
	 *  O/p -> String
	 *  Constraints -> lower case
	 *  
	 * Complexity: O(n)
	 * 
	 * 
	 */
	
	@Test
	public void tc01() {
		String input= "abbaaba";
		Assert.assertTrue(removeDuplicate(input).equals("aba"));
	}
	
	@Test
	public void tc02() {
		String input= "abccba";
		Assert.assertTrue(removeDuplicate(input).equals(""));
	}
	
	@Test
	public void tc03() {
		String input= "abbabba";
		Assert.assertTrue(removeDuplicate(input).equals("a"));
	}
	
	@Test
	public void tc04() {
		String input= "aabbaacbbc";
		Assert.assertTrue(removeDuplicate(input).equals(""));
	}
	
	/*Pseudocode:
	 * 1) Initialise stack
	 * 2) Iterate though the length of the string 
	 * 		a) Peek for the value and push to the stack if no match 
	 * 		b) If macthes, pop the element
	 * 3) return Stack
	 * 	 * 
	 */
	
	private String removeDuplicate(String input) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < input.length()-1; i++) {
			if(stack.isEmpty()) stack.push(input.charAt(i));
			if(!(input.charAt(i+1) == stack.peek())) stack.push(input.charAt(i+1));
			else {
				stack.pop();						
			}				
		}
		out.append(stack.pop());
		System.out.println(out);
		return out.toString();
	}


}
