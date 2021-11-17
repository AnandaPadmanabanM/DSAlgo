package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class MergeArrays {
	/*
			Problem Statement


	 */
	//?

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
		int[] A = {1,3,5};
		int[] B= {2,4,5};
		mergeArrayUsingPointers(A,B);
	}

	@Test
	public void testData02() { // Negative
		int[] A = {6};
		int[] B= {2,4,5};
		mergeArrayUsingPointers(A,B);
	}

	@Test
	public void testData03() { // Edge
		int[] A = {2,3,5};
		int[] B= {4,5};
		mergeArrayUsingPointers(A,B);
	}

	public Set<Integer> mergeArray(int[] A, int[] B) {
		Set<Integer> set = new TreeSet<>();
		int length=A.length>B.length?A.length:B.length;
		for(int i=0;i<length;i++) {
			if(i<A.length) set.add(A[i]);
			if(i<B.length) set.add(B[i]);
		}
		System.out.println(set);
		return set;	
	}


	public List<Integer> mergeArrayUsingPointer(int[] A, int[] B) {
		int left=0;
		int length=A.length>B.length?A.length:B.length;
		List<Integer> list = new LinkedList<>();
		while(left<length) {
			if(left<A.length && !list.contains(A[left])) {
				list.add(A[left]);
			}
			if(left<B.length && !list.contains(B[left])) {
				list.add(B[left]);		
			}
			left++;
		}
		System.out.println(list);
		return list;
	}	
	
	
	public List<Integer> mergeArrayUsingPointers(int[] A, int[] B) {
		int first=0;
		int second=0;
		int length=A.length>B.length?A.length:B.length;
		List<Integer> list = new LinkedList<>();
		while(first<length && second<length) {
			if(first<A.length && !list.contains(A[first]) && A[first]<B[second]) {
				list.add(A[first]);
				first++;
			}
			if(second<B.length && !list.contains(B[second]) && B[second]<A[first]) {
				list.add(B[second]);	
				second++;
			}
			if(second<B.length && !list.contains(B[second]) && B[second]==A[first]) {
				list.add(B[second]);	
				first++;
				second++;
			}
		}
		System.out.println(list);
		return list;
	}	
}
