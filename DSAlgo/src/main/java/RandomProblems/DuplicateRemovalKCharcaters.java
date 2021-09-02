package RandomProblems;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class DuplicateRemovalKCharcaters {
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
		String s = "deeedbbcccbdaae";
		int k = 3;
		Assert.assertTrue(removeDupKthCharacter(s,k).equals("aa"));
	}

	private String removeDupKthCharacter(String s, int k) {
		// TODO Auto-generated method stub
		Stack<Character> out = new Stack<Character>();
		Stack<Integer> count = new Stack<Integer>();
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<s.length();i++) {
			Integer peekCount =0;
			if(!out.empty() && out.peek()==s.charAt(i)) {
				peekCount = count.peek();
				peekCount++;
				out.push(s.charAt(i));
				count.push(peekCount);
			}else {
				out.push(s.charAt(i));
				count.push(1);
			}
			if(peekCount==k) {
				for(int j=0;j<k;j++) {
					out.pop();
					count.pop();
				}	
			}		
		}				
		for(int i=out.size();i>0;i--) {
			Character pop = out.pop();
			sb.insert(i,pop);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}


}
