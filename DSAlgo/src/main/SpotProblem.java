package RandomProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SpotProblem {
	/*
	 * Problem Statement
	 * 
	 * Given an integer n, return a string array answer (1-indexed) where:
	 * 
	 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5. answer[i] == "Fizz" if
	 * i is divisible by 3. answer[i] == "Buzz" if i is divisible by 5. answer[i] ==
	 * i if non of the above conditions are true.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: n = 3 Output: ["1","2","Fizz"]
	 */

	/*
	 * 1. Input(s):integer  Output :String array Constraint(s): HashMap with 2 pointer
	 * 
	 * 2. Test data 
	 * Positive : n=3
	 * Negative : n=0
	 * Edge : n=1
	 * 
	 * 3. Approaches Known Approach :
	 * 
	 * 4. O - Notation
	 * 
	 * 
	 * 5. Pseudocode
	 * 1. Iterate values from 1 to n
	 * 2. If value%3 == 0, then add fizz to the string array
	 * 3. If value%5 == 0, them add buzz  to the string array
	 * 4. If value%3 && value %5==0, then fizzbuzz to the string array
	 * 5. Return String array
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int n=15;
		fizzProblem(n);
	}

	@Test
	public void testData02() { // Negative
		int n=0;
		fizzProblem(n);
	}

	@Test
	public void testData03() { // Edge
		int n=1;
		fizzProblem(n);
	}
	
	private String[] fizzProblem(int n) {		
		String[] out= new String[n];
		for (int i = 1; i <= n; i++) {
			if(i%3==0 && i%5==0) out[i-1]="fizzbuzz";
			else if(i%3 == 0) out[i-1] = "fizz";
			else if(i%5 == 0) out[i-1] = "buzz";	    
			else out[i-1]=String.valueOf(i);		
		}	
		System.out.println(Arrays.toString(out));
		return out;	
	}
	
	private List<String> fizzProblemUsingList(int n) {		
		 List<String> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if(i%3==0 && i%5==0) list.add("FizzBuzz");
				else if(i%3 == 0) list.add("Fizz");
				else if(i%5 == 0)  list.add("Buzz");	    
				else list.add(String.valueOf(i));		
			}	
			System.out.println(list);
			return list;	 
	}
	
}
