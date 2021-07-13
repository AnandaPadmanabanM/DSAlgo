package day2;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

public class TwoPointer {

	/*
	 * Given a string s, return the "reversed" string where all characters that are
	 * not a letter stay in the same place, and all letters reverse their positions.
	 * 
	 * Example 1: Input: s = "ab-cd" Output: "dc-ba" 
	 * Example 2: Input: s ="a-bC-dEf-ghIj" Output: "j-Ih-gfE-dCba" 
	 * Example 3: Input: s = "Test1ng-Leet=code-Q!" Output: "Qedo1ct-eeLg=ntse-T!" 
	 * Example 4: Input: s =
	 * "" Output: Throw exception 
	 * Example 5: Input: s = "a" Output: "a" 
	 * Example 6:	 * Input: s = "&#@" Output: "&#@"
	 * 
	 * Problem solving template 1. Did I understand the problem? yes or no If no ask
	 * the person to provide with more details with examples If yes go to the next
	 * step What is the input(s)? String What is the expected output? String Do I’ve
	 * constraints to solve the problem? Two Pointer Do Ive all the information to
	 * go to the next steps How big is your test data set will be? 2. Test data set
	 * Minimum 3 data set including positive, negative and edge Validate with the
	 * interviewer if the data set is fine by his/ her assumptions 3. Do I know to
	 * solve it? Yes- great is there an alternate ? No - can I break the problem
	 * into sub problems? 4. Ask for hint (if you don’t know how to solve this 5. Do
	 * I know alternate solutions as well Yes- what are those? No- that is still
	 * fine, proceed to solve by what you know Simple technique brute force 6. If
	 * you know the alternate solution find out the O-notations (performance) 7.
	 * Then, explain either both are the best (depends on the time) Approach 1:-
	 * start with the worst-> improve (optimize) -> End up with the best Approach 2:
	 * Write down the options and benefits and code the best 8. Start always with
	 * the Pseudo code 9. Test against different test data 10. If it fails then
	 * debug to solve it
	 * 
	 * 
	 * Pseudocode: 
	 * 1) Input = String 
	 * 2) Output = String 
	 * 3) Test data: Check for
	 * length and throw exception if length =0 
	 * 4) Intiliase left (0) and right pointers (length) and covert to character array 
	 * 5) Iterate till (left<right) --> While loop
	 * 6) Check for character for both positions using isLetter method 
	 * 7) if true,swap the values , increment left and right-- 
	 * 8) if right not a charcter,
	 * right-- 
	 * 9) if left not a charcter. left ++ 
	 * 10)return char array to String
	 * 
	 * Complexity: Time - O(n) Space - O(n)
	 */

	@Test
	public void tc1() {
		String val = "ab-cd";
		String reverse = "dc-ba";
		Assert.assertEquals(reverseUsingTwoPointer(val), reverse);
	}

	@Test
	public void tc2() {
		String val = "a-bC-dEf-ghIj";
		String reverse = "j-Ih-gfE-dCba";
		Assert.assertEquals(reverseUsingTwoPointer(val), reverse);
	}

	@Test
	public void tc3() {
		String val = "Test1ng-Leet=code-Q!";
		String reverse = "Test1ng-Leet=code-Q!";
		Assert.assertEquals(reverseUsingTwoPointer(val), reverse);
	}

	@Test
	public void tc4() {
		String val = " ";
		String reverse = "sd";
		Assert.assertEquals(reverseUsingTwoPointer(val), reverse);
	}

	@Test
	public void tc5() {
		String val = "a";
		String reverse = "a";
		Assert.assertEquals(reverseUsingTwoPointer(val), reverse);
	}

	@Test
	public void tc6() {
		String val = "&^%";
		String reverse = "&^%";
		Assert.assertEquals(reverseUsingTwoPointer(val), reverse);
	}

	private String reverseUsingTwoPointer(String val) {
		if (val.trim().length() == 0 )
			throw new RuntimeException("InValid Input");
		
		if (val.trim().length() == 1 ) return val;
			
		int left = 0, right = val.length() - 1;

		char[] valArray = val.toCharArray();

		while (left < right) {

			if (!Character.isLetter(valArray[left]))
				left++;
			if (!Character.isLetter(valArray[right]))
				right--;

			if (Character.isLetter(valArray[left]) && Character.isLetter(valArray[right])) {
				char swap = valArray[left];
				valArray[left++] = valArray[right];
				valArray[right--] = swap;
			}
			
		}
		return new String(valArray);

	}



}
