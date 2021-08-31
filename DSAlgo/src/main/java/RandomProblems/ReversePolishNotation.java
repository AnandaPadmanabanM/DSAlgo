package RandomProblems;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class ReversePolishNotation {
	/*
	 * Problem Statement Evaluate the value of an arithmetic expression in Reverse
	 * Polish Notation.
	 * 
	 * Valid operators are +, -, *, and /. Each operand may be an integer or another
	 * expression.
	 * 
	 * Note that division between two integers should truncate toward zero.
	 * 
	 * It is guaranteed that the given RPN expression is always valid. That means
	 * the expression would always evaluate to a result, and there will not be any
	 * division by zero operation.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) =
	 * 9
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
		String[] tokens = {"2","1","+","3","*"};
		Assert.assertTrue(findReversePolishNotation(tokens)==9);
	}
	@Test
	public void testData02() { // Positive
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		Assert.assertTrue(findReversePolishNotation(tokens)==22);
	}
	
	private int findReversePolishNotation(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		int num1=0,num2=0,out=0;
		for (int i = 0; i < tokens.length; i++) {
			if(tokens[i].length()>1 || Character.isDigit(tokens[i].charAt(0))) stack.push( Integer.parseInt(tokens[i]));
			else {
				num2=stack.pop();
				num1=stack.pop();
				out =operation(tokens[i],num1,num2);
				stack.push(out);
			}			
		}
		System.out.println(out);
		return stack.pop();
	}
	
	 public int operation(String token, int a, int b) {
	        if (token.equals("+")) return a+b;
	        else if (token.equals("-")) return a-b;
	        else if (token.equals("*")) return a*b;
	        return a/b;
	    }

}
