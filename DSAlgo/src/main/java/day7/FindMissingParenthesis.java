package day7;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class FindMissingParenthesis {

	/*
	 * 
	 * Find out how many missing brackets to make a valid parentheses !! 
	Input can have only open and closing brackets ( )
	String st = “((((” -> 4 brackets 
	String st = “(()))” -> 1 bracket 
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void tc01() {
		String input= "((((";
		Assert.assertTrue(findMissingParenthesis(input)==4);
	}
	
	@Test
	public void tc02() {
		String input= "(()))";
		Assert.assertTrue(findMissingParenthesis(input)==1);
	}
	//)
	/*Pseudocode:
	 * 1. Initilaise map with closing brackets as key and opening braces as value
	 * 2. Convert String to char array
	 * 3. Initialise counter =0 & stack;
	 * 4. Iterrate rhough the input array and check with key of map
	 *   	- push it to the stack if it not contains and repeat it 
	 * 		- pop it if it matches
	 * 5. return stack size
	 * 
	 */

	private int findMissingParenthesis(String input) {
		char[] charArray = input.toCharArray();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('>', '<');
		map.put('}', '{');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(Character ch:charArray){
			if(!map.containsKey(ch)) {
				stack.push(ch);
			} 
			else if(stack.isEmpty() || stack.pop() != map.get(ch))
			  return stack.size();
		}
		
		return stack.size();
	}
}
