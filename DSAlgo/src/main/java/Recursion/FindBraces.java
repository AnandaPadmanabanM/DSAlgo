package Recursion;

import org.junit.Test;

public class FindBraces {
	/*
	 * Problem Statement Given an encoded string, return its decoded string.
	 * 
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the
	 * square brackets is being repeated exactly k times. Note that k is guaranteed
	 * to be a positive integer.
	 * 
	 * You may assume that the input string is always valid; No extra white spaces,
	 * square brackets are well-formed, etc.
	 * 
	 * Furthermore, you may assume that the original data does not contain any
	 * digits and that digits are only for those repeat numbers, k. For example,
	 * there won't be input like 3a or 2[4].
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "3[a]2[bc]" Output: "aaabcbc" Example 2:
	 * 
	 * Input: s = "3[a2[c]]" Output: "accaccacc" Example 3:
	 * 
	 * Input: s = "2[abc]3[cd]ef" Output: "abcabccdcdcdef" Example 4:
	 * 
	 * Input: s = "abc3[cd]xyz" Output: "abccdcdcdxyz"
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
	 * test
	 * 
	 * 5. Pseudocode
		1) Base conditions-> length =0,
		2) Test data -> 3[a]2[bc]
		3) Recursive logic 
			a) Ignore braces
			b) Append characters to the output string
			c) if digit found, reverse and append to the output string based on the digit 
	 *  4)
	 *   3[a2[c]]
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "3[a]2[bc]";
		System.out.println(decodeWords(input));
	}

	@Test
	public void testData02() { // Positive
		String input = "3[a2[c]]";
		System.out.println(decodeWords(input));
	}

	@Test
	public void testData03() { // Positive
		String input = "100[leetcode]";
		System.out.println(decodeWords(input));
	}


	private String decodeWords(String input ) {
		if(!input.contains("]")) return input;
		String out ="";
		String digit ="";
		int a= 0;
		int count=1;
		int index2 =input.indexOf(']');
		int index1 =input.substring(0, index2).lastIndexOf('[');
		String substring = input.substring(index1+1,index2);
		while(index1-count>=0 && Character.isDigit(input.charAt(index1-count))) {
			a = Character.isDigit(input.charAt(index1-count)) ? Character.getNumericValue(input.charAt(index1-1)):1;
			digit= input.substring(index1-count,index1);
			count++;
		}
		a=Integer.parseInt(digit);
		index1=index1-count+2;
//		if(a==0) {
//			while(a==0){
//				a = Character.isDigit(input.charAt(index1-count)) ? Character.getNumericValue(input.charAt(index1-count)):1;
//				digit= input.substring(index1-count,index1);
//				count++;	 
//			}
//			a=Integer.parseInt(digit);
//			index1=index1-count+1;
//		}
		while(a>0){
			out+=substring;
			a--;
		}
		input=input.substring(0,index1-1)+out+input.substring(index2+1,input.length());

		return decodeWords(input);	

	}

}
