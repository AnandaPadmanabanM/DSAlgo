package day4;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheck {

	/*
	 *
	P2) Valid Palindrome after deleting one or zero character

	Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 
	Example 1:
	Input: s = "aba"
	Output: true
	 * 
	 * 
	 * 
	 */
	@Test //positive case
	public void tc1() { 
		String input = "aba";	
		Assert.assertEquals(checkForPalindrome(input), true);
	}

	@Test // negative case
	public void tc2() { 
		String input = "abc";	
		Assert.assertEquals(checkForPalindrome(input), false);
	}

	@Test // edge case
	public void tc3() { 
		String input = "abca";	
		Assert.assertEquals(checkForPalindrome(input), true);
	}


	@Test // edge case
	public void tc4() { 
		String input = "abccba";	
		Assert.assertEquals(checkForPalindrome(input), true);
	}

	@Test // -ve case
	public void tc5() { 
		String input = "acccbaf";	
		Assert.assertEquals(checkForPalindrome(input), false);
	}

	private boolean checkForPalindrome(String input) {

		HashSet<Character> set = new HashSet<>();
		for(int i=0; i<input.length();i++) {
			if(!set.add(input.charAt(i))) {
				set.remove(input.charAt(i));
			}			
		}
		set.remove(0);
		if(set.size()>1) return false;
		else {
			int left = 0, right = input.length() - 1;
			while (left < right) {
				if (!Character.isLetterOrDigit(input.charAt(left)))
					left++;
				if (!Character.isLetterOrDigit(input.charAt(right)))
					right--;
				if (Character.isLetterOrDigit(input.charAt(left)) && Character.isLetterOrDigit(input.charAt(right))) {
					if (input.charAt(left) != input.charAt(right))
						return false;
					else {
						left++;
						right--;
					}
				}		
			}
		}
		return true;
	}
}
