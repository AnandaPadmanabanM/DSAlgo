package HackerRank;

import org.junit.Test;

import junit.framework.Assert;

public class ConvertNumericToRoman {
	/*
			Problem Statement


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


	   5.  Pseudocode		

	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int num=3;
		Assert.assertTrue(convertInttoRoman(num).equals("III"));
	}

	@Test
	public void testData02() { // Negative
		int num=4;
		Assert.assertTrue(convertInttoRoman(num).equals("IV"));
	}

	@Test
	public void testData03() { // Edge
		int num=21;
		Assert.assertTrue(convertInttoRoman(num).equals("LVIII"));
	}

	private String convertInttoRoman(int num) {

		String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String out="";
		int ptr=0;
		while(num>0) {
			if(num>=value[ptr]) {
				num-=value[ptr];
				out+=romanValues[ptr];
			}
			if(ptr<value.length-1 && num < value[ptr] )ptr++;
		}
		System.out.println(out);
		return out;
	}

}
