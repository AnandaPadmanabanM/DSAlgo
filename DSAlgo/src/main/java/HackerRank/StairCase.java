package HackerRank;

import org.junit.Test;

import junit.framework.Assert;

public class StairCase {
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
		int n=6;
		staircase(n);
	}

	
	 private void staircase(int n) {
		    // Write your code here
		 int count=1;
         for(int i=n;i>0;i--){
             for(int j=n;j>0;j--){
               if(j<=count)     System.out.print("#"); 
               else  System.out.print(" ");                
             } 
              System.out.println();
              count++;
            }
		    }
}
