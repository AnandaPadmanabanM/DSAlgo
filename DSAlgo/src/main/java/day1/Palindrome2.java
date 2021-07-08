package day1;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Palindrome2 {
	int val=0;
	/*
	 * Problem solving template
		1. Did I understand the problem? yes or no
        	If no ask the person to provide with more details with examples
        	If yes go to the next step
        	What is the input(s)?
        	What is the expected output?
        	Do I’ve constraints to solve the problem?
        	Do Ive all the information to go to the next steps
        	How big is your test data set will be?
		2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions
		3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?
		4. Ask for hint (if you don’t know how to solve this
		5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know
		6. If you know the alternate solution find out the O-notations (performance)
		7. Then, explain either both are the best (depends on the time)
       		Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        	Approach 2: Write down the options and benefits and code the best
		8. Start always with the Pseudo code
		9. Test against different test data
		10. If it fails then debug to solve it
		
		
	 * Pseudocode
	 * 	1) Yes, with any input value 
	 *  2) positive -> 1232, 6 (single value)
	 *     negative -> -183, empty value
	 *     edge -> 16900
	 *  3) yes  
	 *  4) Not required
	 *  5) Modulo operator, recursion
	 */


	@SuppressWarnings("deprecation")
	@Test 
	public  void test1()
	{
		int input= 4224;
		boolean palindromeCheck = palindrome(input);
		System.out.println(palindromeCheck);

		Assert.assertEquals(true, palindromeCheck);
	}
	
	@Test 
	public  void test2()
	{
		int input= 12389;
		boolean palindromeCheck = palindrome(input);
		System.out.println(palindromeCheck);

		Assert.assertEquals(false, palindromeCheck);
	}

	@Test 
	public  void test3()
	{
		int input= -8998;
		
		boolean palindromeCheck = palindrome(input);
		System.out.println(palindromeCheck);
		Assert.assertEquals(true, palindromeCheck);
	}
	
	@Test 
	public  void test4()
	{
		int input= 0100;
		
		boolean palindromeCheck = palindrome(input);
		System.out.println(palindromeCheck);
		
		Assert.assertEquals(false, palindromeCheck);
	}
	

	private boolean palindrome(int input) {
		boolean negativeInt = input<0?true:false;
		 if(negativeInt)  	Math.abs(input);
		    
		String input1 = String.valueOf(input);
		if (input1 == null)
			throw new IllegalArgumentException("Invalid Input");

		StringBuilder out = new StringBuilder();

		char[] chars = input1.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--)
			out.append(chars[i]);

		int parseInt = Integer.parseInt(out.toString());
		
		if(negativeInt)  	{
			input = input * -1;
			parseInt = parseInt * -1;
		}
		
		 
		if (parseInt==input) return true;
		else return false;
			
	
	}

	

}