package RandomProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseList {
	/*
			Problem Statement
			For given integer list as i/p, reverse the list
			
		*/

	/*
	   1. 
	  	  Input(s): List
		  Output : List
		  Constraint(s):
	   
	   2. Test data
			Positive : {}
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : 
	
	   4.  O - Notation O(n), O(n)
			  
	
	   5.  Pseudocode	
	    1) If list size	is <=1, return input
	    2) Initialise the list 
	    3)Traverse through the list from last index and add it to the new list
		4) Return list
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(14);
		list.add(8);
		list.add(1);	
		System.out.println(reverseList(list));
	}


	@Test
	public void testData02() { // Negative
		List<Integer> list = new ArrayList<Integer>();	
		System.out.println(reverseList(list));
	}

	@Test
	public void testData03() { // Edge
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(2);
		System.out.println(reverseList(list));
	}
	
	private List<Integer> reverseList(List<Integer> list) {	
		if(list.size() <=1 ) return list;
		List<Integer> reverseList = new ArrayList<Integer>();
		for (int i =list.size()-1 ; i>=0; i--) {
			reverseList.add(list.get(i));			
		}
				
		return reverseList;
	}
	
	private List<Integer> reverseListTwoPointer(List<Integer> list) {	
		if(list.size() <=1 ) return list;
		int left=0, right=list.size()-1;
		while(left<=right) {
			int temp=list.get(right);
			list.set(right, list.get(left));
			list.set(left, temp);
		}
		
		return list;
	}
}
