package RandomProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SPotProblem2 {
	/*
			Problem Statement


	 */

	/*
	   1. 
	  	  Input(s):String, integer array
		  Output : boolean array
		  Constraint(s):

	   2. Test data
			Positive : abbccaadf [4 2 5 3 7]
			Negative :	
			Edge     :

	   3.  Approaches Known 
			 Approach : 2 pointer with sliding window

	   4.  O - Notation 


	   5.  Pseudocode	
	   	   1) Initilaise 2 pointers with left =0 , right =0
	   	   2) Initialsie Hashmap and store alphabetic values from a =1 to z =26
	   	   3) Convert String to char array
	   	   4) Initialse sum and add value based on character
	   	   5) Increment right pointer by 1
	   	   6) if character is same, then add respective value to the sum else return boolean value based on the target values
		   7) Increment left pointer
		   8) Repeat till end of the char array
		   9) Return boolean values
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "abbccaadf";
		int[] target = {4,2,5,3,7};
		Assert.assertEquals(findUniform(input,target) ,new boolean[] {true, true, true, false, false});

	
	}

	@Test
	public void testData02() { // Negative
		String input = "abdd";
		int[] target = {5};
		Assert.assertEquals(findUniformUsingHashMap(input,target) ,new boolean[] {false});
	}

	@Test
	public void testData03() { // Edge
		String input = "abcd";
		int[] target = {4};
		Assert.assertEquals(findUniformUsingHashMap(input,target) ,new boolean[] {true});
	}

	private boolean[] findUniform(String input, int[] target) {
		int left =0,right=0;
		Set<Integer> set = new HashSet<>();
		boolean[] out = new boolean[target.length];
		while(left < input.length()) {
			int sum=0;
			while (right < input.length()) {
				if(input.charAt(left) == input.charAt(right)) {
					sum+=(int) input.charAt(right++)-96;
					set.add(sum);
				}else break;
			}
			left++;		
		}
		for (int i = 0; i < target.length; i++) {
			if(set.contains(target[i])) out[i]=true;
			else out[i]=false;	
		}
		System.out.println(Arrays.toString(out));
		return out;
	}
	
	private Collection<Boolean> findUniformUsingHashMap(String input, int[] target) {
		int left =0,right=0;
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < target.length; i++) {
			map.put(target[i], false);
		}
		while(left < input.length()) {
			int sum=0;
			while (right < input.length()) {
				if(input.charAt(left) == input.charAt(right)) {
					sum+=(int) input.charAt(right++)-96;
					if(map.containsKey(sum)) map.put(sum, true);
				}else break;
			}
			left++;		
		}
		System.out.println(map.values());
		return map.values();
	}


}
