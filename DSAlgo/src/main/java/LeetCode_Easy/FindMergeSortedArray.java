package LeetCode_Easy;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindMergeSortedArray {
	/*
			Problem Statement
			88. Merge Sorted Array
			
			
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
		int[] nums1= {0};
		int m=0;
		int[] nums2= {1};
		int n=1;
		Assert.assertTrue(Arrays.equals(findmerge(nums1,m,nums2,n),new int[] {1}));
	}

	@Test
	public void testData02() { // Negative
		int[] nums1= {1,2,3,0,0,0};
		int m=3;
		int[] nums2= {2,5,6};
		int n=3;
		Assert.assertTrue(Arrays.equals(findmerge(nums1,m,nums2,n),new int[] {1,2,2,3,5,6}));
	}

	@Test
	public void testData03() { // Edge
		int[] nums1= {1};
		int m=1;
		int[] nums2= {};
		int n=0;
		Assert.assertTrue(Arrays.equals(findmerge(nums1,m,nums2,n),new int[] {1}));
	}
	
	 public int[] findmerge(int[] nums1, int m, int[] nums2, int n) {
	        System.out.println(Arrays.toString(nums2));
	       if(m==1 && n==0) return nums1;
	       else if(m==0 && n==1) return nums2; 
	       for(int i=n;i<nums1.length;i++){
	           nums1[i]=nums2[i-n];
	       } 
	        System.out.println(Arrays.toString(nums1));
	        Arrays.sort(nums1);
	        return nums1;
	    }
}
