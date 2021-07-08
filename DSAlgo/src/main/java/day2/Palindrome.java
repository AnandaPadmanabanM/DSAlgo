package day2;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Palindrome {
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
	 * 	1) Check for sign of integer
	 *  2) if negative, make it as positive
	 *  3) Find the last digit of the integer using modulo operator to reverse
	 *  4) Check for solutions --> Brute Force, Recursion 
	 *  5) Update the value based on the sign of the input
	 *  6) Compare the values and return true if matches
	 *  
	 *  Complexity:
	 *  Time  - O(n)
	 *  Space - O(1)
	 * 
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
		int input= 010;
		
		boolean palindromeCheck = palindrome(input);
		System.out.println(palindromeCheck);
		
		Assert.assertEquals(true, palindromeCheck);
	}
	

	private boolean palindrome(int input) {
		
		boolean negativeInt = input<0?true:false;
		int temp = input;
	    if(negativeInt) input = input * -1;
	    
		if(input>0) 
		{
			val=val*10+input%10;
			palindrome(input/10);
		}

		val =negativeInt == true? val*-1: val;		
		return val == temp? true:false;
	}

	

}