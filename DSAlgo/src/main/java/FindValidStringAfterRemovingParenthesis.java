import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class FindValidStringAfterRemovingParenthesis {
	/*
	 * Problem Statement Problem 1:
	 * 
	 * Remove the minimum number of parentheses ( '(' or ')', in any positions ) so
	 * that the resulting parentheses string is valid and return any valid string.
	 * 
	 * Formally, a parentheses string is valid if and only if:
	 * 
	 * It is the empty string, contains only lowercase characters, or It can be
	 * written as AB (A concatenated with B), where A and B are valid strings, or It
	 * can be written as (A), where A is a valid string.   Example 1:
	 * 
	 * Input: s = “abc(a(c)e)de)" Output: “abc(a(c)e)de" Explanation:
	 * “abc(a(ce)de)" , “abc(a(c)ede)" would also be accepted.
	 * 
	 * Example 2:
	 * 
	 * Input: s = "a)b(c)d" Output: "ab(c)d"
	 * 
	 * Example 3:
	 * 
	 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
	 * 
	 * Example 4:
	 * 
	 * Input: s = "(a(b(c)d)" Output: "a(b(c)d)"
	 * 
	 * 
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
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input="abc(a(c)e)de)";
		Assert.assertTrue(findValidString(input).equals("abc(a(c)e)de"));
	}
	
	@Test
	public void testData02() { // Negative
		String input="a)b(c)d";
		Assert.assertTrue(findValidString(input).equals("ab(c)d"));
	}

	@Test
	public void testData03() { // Edge
		String input="))((";
		Assert.assertTrue(findValidString(input).equals(""));
	}
	
	@Test
	public void testData04() { // Edge
		String input="(a(b(c)d)";
		Assert.assertTrue(findValidString(input).equals("a(b(c)d)"));
	}
	
	/*
	 * Pseudocode:
	 * 1) Initialise 2 Stacks and store values of character and indices
	 * 2) Traverse through the String by character
	 * 3) Check if stack is not empty and if the input charater is ')' and peek element is '(', then pop from both stacks
	 *   else push it to the stack
	 * 4) If stack is empty, push characters and indices to the stacks
	 * 5) if stack is empty, then return the input
	 * 6)  else remove those chacaters from the input string based on the index
	 * 
	 */

	private String findValidString(String input) {
		Stack<Character> charStack = new Stack<Character>();
		Stack<Integer> indexStack = new Stack<Integer>();
		
		for (int i = 0; i < input.length(); i++) {
			if(!charStack.isEmpty()) {
				if(input.charAt(i) ==')'  && charStack.peek() == '(' ) {
					charStack.pop();
					indexStack.pop();
				}
				else if(!Character.isLetter(input.charAt(i))) {
					charStack.push(input.charAt(i));
					indexStack.push(i);
				}
				}else if(!Character.isLetter(input.charAt(i))) {
					charStack.push(input.charAt(i));
					indexStack.push(i);
			}			
		}
		if(charStack.isEmpty()) return input;
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		for(int index:indexStack) {
			sb.deleteCharAt(index);
			sb.insert(index, " ");
		}
		System.out.println( sb.toString().replace(" ", ""));
		return sb.toString().replace(" ", "");
	}

	
}
