package HackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class Problem2 {
	/*
			Problem Statement


	 */

	/*
	   1. 
	  	  Input(s):Integer Array
		  Output : integer
		  Constraint(s):

	   2. Test data
			Positive : 
			Negative :	
			Edge     :

	   3.  Approaches Known 
			 Approach : 

	   4.  O - Notation 


	   5.  Pseudocode		
		 1) initialise counter for duplicate, left & right pointers
		 2) Comapare the values based on the index by iterating though the array
		 3) if same, increment counter
		 4) return counter
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		List<String> ip1 = new ArrayList<>();
		ip1.add("Ball");
		ip1.add("Bat");
		ip1.add("Ball");
		ip1.add("Ball");
		
		List<Integer> ip2 = new ArrayList<>();
		ip2.add(2);
		ip2.add(2);
		ip2.add(2);
		ip2.add(2);
		
		List<Integer> ip3 = new ArrayList<>();
		ip3.add(2);
		ip3.add(2);
		ip3.add(2);
		ip3.add(2);
		
		findDuplicateUsingSet(ip1,ip2,ip3);
	}

	@Test
	public void testData02() { // Positive
		List<String> ip1 = new ArrayList<>();
		ip1.add("Ball");
		ip1.add("Bat");
		ip1.add("Ball");
		ip1.add("Ball");
		
		List<Integer> ip2 = new ArrayList<>();
		ip2.add(2);
		ip2.add(2);
		ip2.add(2);
		ip2.add(2);
		
		List<Integer> ip3 = new ArrayList<>();
		ip3.add(2);
		ip3.add(2);
		ip3.add(2);
		ip3.add(1);
		
		findDuplicateUsingSet(ip1,ip2,ip3);
	}
	
	@Test
	public void testData03() { // Positive
		List<String> ip1 = new ArrayList<>();
		ip1.add("Ball");
		ip1.add("Bat");
		ip1.add("Glove");
		ip1.add("Glove");
		ip1.add("Glove");
		
		List<Integer> ip2 = new ArrayList<>();
		ip2.add(12);
		ip2.add(3);
		ip2.add(1);
		ip2.add(2);
		ip2.add(1);
		
		List<Integer> ip3 = new ArrayList<>();
		ip3.add(12);
		ip3.add(5);
		ip3.add(1);
		ip3.add(1);
		ip3.add(1);
		
		findDuplicateUsingSet(ip1,ip2,ip3);
	}
	
	@Test
	public void testData04() { // Positive
		List<String> ip1 = new ArrayList<>();
		ip1.add("Ball");
		ip1.add("Bat");
	
		List<Integer> ip2 = new ArrayList<>();
		ip2.add(2);
		ip2.add(2);
		
		List<Integer> ip3 = new ArrayList<>();
		ip3.add(2);
		ip3.add(2);
		
		findDuplicateUsingSet(ip1,ip2,ip3);
	}
	@Test
	public void testData05() { // Positive
		List<String> ip1 = new ArrayList<>();
		ip1.add("Ball");
		ip1.add("Ball");
		ip1.add("Ball");
		ip1.add("Ball");
		
		List<Integer> ip2 = new ArrayList<>();
		ip2.add(2);
		ip2.add(2);
		ip2.add(2);
		ip2.add(2);
		
		List<Integer> ip3 = new ArrayList<>();
		ip3.add(2);
		ip3.add(2);
		ip3.add(2);
		ip3.add(2);		
		findDuplicateUsingSet(ip1,ip2,ip3);
	}

	private int findDuplicate(List<String> ip1, List<Integer> ip2, List<Integer> ip3) {
		int counter=0;
		int left=0;
		while (left<ip1.size()) {
			int right=left+1;
			int length=ip1.size();
			while(right<ip1.size()) {
				if(ip1.get(left).equals(ip1.get(right)) && ip2.get(left)==ip2.get(right) 
							&& ip3.get(left)==ip3.get(right)) {
					counter++;
					ip1.remove(right);
					ip2.remove(right);
					ip3.remove(right);
					right--;
				}
				right++;	
			}
			left++;
		}	
		System.out.println(counter);
		return counter;		
	}
	
	private int findDuplicateUsingSet(List<String> ip1, List<Integer> ip2, List<Integer> ip3) {
		int counter=0;
		Set<String> set= new HashSet<>();
		for (int i = 0; i < ip1.size(); i++) {
			if(!set.add(ip1.get(i)+ip2.get(i)+ip3.get(i))) {
				counter++;	
			}
		}
		System.out.println(counter);
		return counter;		
	}
}
