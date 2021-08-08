package QueueProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class FindValidParenthesesLength {
	

	@Test
	public void test1() {
		String input = "()(()";
		Assert.assertTrue(findValidParenLength(input) == 2);
	}

	private int findValidParenLength(String input) {
		
		 char[] charArray = input.toCharArray();
			HashMap<Character, Character> map = new HashMap<Character, Character>();
			map.put(')', '(');
			
			Stack<Character> stack = new Stack<Character>();
	        int count=0;
			
			for(Character ch:charArray){
				if(!map.containsKey(ch)) {
					stack.push(ch);
				}
				else if(!stack.isEmpty() && stack.pop() == map.get(ch))
				  count = count+2;
	            else if(stack.isEmpty() || stack.pop() != map.get(ch))
	             count=0;  
				 continue;
			}
			
			return count;
	
	
	}

}
