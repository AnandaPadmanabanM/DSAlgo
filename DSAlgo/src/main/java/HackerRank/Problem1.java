package HackerRank;

import org.junit.Test;

import junit.framework.Assert;

public class Problem1 {
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
		String password="2bbbb";
		int n=5;
		Assert.assertTrue(minimumNumber(n,password)== 2);
	}

	@Test
	public void testData02() { // Negative
		String password="#HackerRank";
		int n=11;
		Assert.assertTrue(minimumNumber(n,password)== 1);

	}

	@Test
	public void testData03() { // Edge
		String password="Ab1";
		int n=3;
		Assert.assertTrue(minimumNumber(n,password)== 3);
	}	
	
	@Test
	public void testData04() { // Positive
		String password="2bb#A";
		int n=5;
		Assert.assertTrue(minimumNumber(n,password)== 1);
	}
	public int minimumNumber(int n, String password) {
		int count=0;
		String special="!@#$%^&*()-+";
		boolean isUppercase = false;
		boolean isLowerCase = false;
		boolean isDigit = false;
		boolean isSpecialChar = false;	
		
		for (int i = 0; i < password.length(); i++) {	
			if(Character.isUpperCase(password.charAt(i))) isUppercase = true;
			else if(Character.isLowerCase(password.charAt(i))) isLowerCase = true;
			else if(Character.isDigit(password.charAt(i))) isDigit = true;
			else if(special.contains((password.charAt(i)+""))) isSpecialChar = true;			
		}
		    if(!isUppercase) count++;
		    if(!isLowerCase) count++;
		    if(!isDigit) count++;
		    if(!isSpecialChar) count++;
		    
		    if(password.length()>=6) return count;
		    else {
		    	 if((count+n)>=6) return count;
		            else return (6-(n+count))+count;
		    }
	}
}
