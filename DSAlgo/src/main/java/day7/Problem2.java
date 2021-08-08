package day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class Problem2 {

	/*
	 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.  .
	 * 
	 * 
	 * 
	Input - String
    Output- int
    Constraints- no constraints

	2. Test data set

	        Positive : 
	        Negative : 
	        Edge     : 

	3. Solution Approach: 

	4. O-Notation:

	5. Pseudocode:
		1) if the length of the input, target 

	 */

	
	@Test
	public void testData01() // positive
	{
		int[] arr= {1,1,1,1,1};
		int k =1;
		int threshold=0;
		Assert.assertTrue(numOfSubarrays(arr,k,threshold)==5);
	}
	
//	@Test
//	public void testData01() // positive
//	{
//		String input="abcabc";
//		Assert.assertTrue(numberOfSubstrings(input)==10);
//	}

	//	@Test
	//	public void testData01() // positive
	//	{
	//		String input="hello";
	//		String target="ll";
	//		Assert.assertTrue(findTargetFirstIndex(input,target)==2);
	//	}


	@Test
	public void testData02() // negative
	{
		String input="aaaaa";
		String target="bba";
		Assert.assertTrue(findTargetFirstIndex(input,target)==-1);
	}

	@Test
	public void testData03() // edge
	{
		String input="";
		String target="";
		Assert.assertTrue(findTargetFirstIndex(input,target)==0);
	}

	@Test
	public void testData04() // edge
	{
		String input="needle";
		String target="dlee";
		Assert.assertTrue(findTargetFirstIndex(input,target)==-1);
	}


	private int findTargetFirstIndex(String input, String target) {
		if(input.length() ==0 || target.length()==0) return 0;
		for (int i = 0; i < input.length()-1; i++) {
			if(input.charAt(i) == target.charAt(0)) {
				if(i+target.length() > input.length()) break;
				if(input.substring(i,i+target.length()).equals(target)) 
					return i;
			}		
		}	
		return -1;
	}

	public int numberOfSubstrings(String s) {
		Set<Character> inputSet = new HashSet<>();
		Set<Character> patternSet = new HashSet<>();
		patternSet.add('a');
		patternSet.add('b');
		patternSet.add('c');
		int count =0;

		for(int i=0;i<s.length();i++){
			inputSet.add(s.charAt(i));
			for(int j=i+1;j<s.length();j++){
				inputSet.add(s.charAt(j));
				if(inputSet.equals(patternSet)) {
					count+=s.length()-j;
					inputSet.removeAll(patternSet);
					break;
				}
			}
		}
		return count;
	}
	
	 public int numOfSubarrays(int[] arr, int k, int threshold) {
	        int count=0;
			for(int i=0;i<=arr.length-k;i++){
	           int sum= arr[i];
	           if(k==1 && (sum/k)>= threshold) count++;
				for(int j=i+1;j<i+k;j++){
					sum+=arr[j];
	                if((sum/k)>= threshold){
	                    count++;
	                    break;
	                }              
				}
	            sum=0;
			}
			System.out.println(count);
			return count;       
	    }
}
