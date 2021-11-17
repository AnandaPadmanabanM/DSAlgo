package ClassRoom;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class FindValidParenthesis {
	/*
			Problem Statement
			Find valid Parenthesis for given input [ , {, (

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


	   Pseudocode:
	 * 1. Initilaise map with closing brackets as key and opening braces as value
	 * 2. Convert String to char array
	 * 3. Initialise counter =0 & stack;
	 * 4. Iterate rhough the input array and check with key of map
	 *   	- push it to the stack if it not contains and repeat it 
	 * 		- pop it if it matches
	 * 5. return true if stack size is zero else false

	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "[{}()]";
		Assert.assertTrue(findValidParenthesis(input));
	}

	@Test
	public void testData02() { // Negative
		String input = "[{}(]";
		Assert.assertFalse(findValidParenthesis(input));
	}

	@Test
	public void testData03(){ // Negative
		String input = "[{}<>]";
		Assert.assertFalse(findValidParenthesis(input));
	}

	@Test
	public void testData04() { // Positive
		String input = "[{()}]";
		Assert.assertTrue(findValidParenthesis(input));
	}
	
	

	private boolean findValidParenthesis(String input) {
		char[] charArray = input.toCharArray();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Stack<Character> stack = new Stack<Character>();
		for(Character ch:charArray){
			if(!map.containsKey(ch)) {
				stack.push(ch);
			}
			else if(stack.isEmpty() || stack.pop() != map.get(ch))
				return false;			
		}
		
		return true;
	}
}
