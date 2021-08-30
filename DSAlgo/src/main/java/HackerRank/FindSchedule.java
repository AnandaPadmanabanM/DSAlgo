package HackerRank;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindSchedule {
	/*
			Problem Statement


	 */

	/*
	   1. 
	  	  Input(s): Integer array
		  Output : int
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
		int[] start= {1,1,2};
		int[] end= {3,2,4};
		Assert.assertTrue(findSchedule(start,end)==2);
	}

	@Test
	public void testData02() { // Positive
		int[] start= {1,1,2,2};
		int[] end= {4,2,4,3};
		Assert.assertTrue(findSchedule(start,end)==2);
	}
	
	@Test
	public void testData03() { // Edge
		int[] start= {1,1,1,1};
		int[] end= {2,2,2,2};
		Assert.assertTrue(findSchedule(start,end)==1);
	}
	
	@Test
	public void testData04() { // Positive
		int[] start= {1,2,3};
		int[] end= {2,3,4};
		Assert.assertTrue(findSchedule(start,end)==3);
	}
	
	@Test
	public void testData05() { // Negative
		int[] start= {1,1,1,1};
		int[] end= {1,1,1,1};
		Assert.assertTrue(findSchedule(start,end)==0);
	}

	private int findSchedule(int[] start, int[] end) {	
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		int[] diff = new int[start.length];
		for (int i = 0; i < start.length; i++) {
			min=Math.min(start[i], min);
			max=Math.max(end[i], max);
			diff[i] = end[i]-start[i];
		}
		if(min == max) return 0;
		int attend=0,sum=0;
		Arrays.sort(diff);
		for (int i = 0; i < diff.length; i++) {
				sum+=diff[i];
				if(sum <=(max-min)) attend++;
		}
		System.out.println(attend);
		return attend;
	}
}
