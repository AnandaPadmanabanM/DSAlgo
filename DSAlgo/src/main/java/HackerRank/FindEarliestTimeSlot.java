package HackerRank;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindEarliestTimeSlot {
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
	    public void test1(){
	        int [] []slots1={{10,50},{60,120},{140,210}};
	        int [] []slots2={{0,15},{60,70}};
	        int duration=8;
	        Assert.assertTrue(Arrays.equals(findCommonSlot(slots1,slots2,duration),new int[]{60,68}));
	    }
	    @Test
	    public void test2(){
	        int [] []slots1={{10,50},{60,120},{140,210}};
	        int [] []slots2={{0,15},{60,70}};
	        int duration=12;
	        Assert.assertTrue(Arrays.equals(findCommonSlot(slots1,slots2,duration),new int[]{}));
	 
	    }
	    @Test
	    public void test3(){
	        int [] []slots1={{10,20},{40,70},{80,120}};
	        int [] []slots2={{30,35},{125,135}};
	        int duration=5;
	        Assert.assertTrue(Arrays.equals(findCommonSlot(slots1,slots2,duration),new int[]{}));
	    }
	    /*
	    - initialize pointers as slotOneStart=0,slotOneEnd=0, slotTwoStart=0, slotTwoEnd=0
	    - Sort both slots arrays by start time
	    - iterate the slots1 and slots2 arrays and find the Max start point and min end time
	    - if the diff of max start time and min end time is less than or equals to duration then
	    - return the start time and start+duration as an output
	     */

	    private int[] findCommonSlot(int[][] slots1, int[][] slots2,int duration) {
	        int slotOneStart=0, slotTwoStart=0;
	        Arrays.sort(slots1,(a,b)->{if(a[0]!=b[0]) return a[0]-b[0]; else return a[1]-b[1];});
	        Arrays.sort(slots2,(a,b)->{if(a[0]!=b[0]) return a[0]-b[0]; else return a[1]-b[1];});

	        int maxStartTime=0, minEndTime=0;

	        while (slotOneStart<slots1.length && slotTwoStart<slots2.length){
	            int slot1Diff=Math.abs(slots1[slotOneStart][0]-slots1[slotOneStart][1]); //40
	            int slot2Diff=Math.abs(slots2[slotOneStart][0]-slots2[slotOneStart][1]); //15
	            int[] bigSlot=new int[2];
	            int[] smallSlot=new int[2];

	            if(slot1Diff>slot2Diff){
	                bigSlot[0]=slots1[slotOneStart][0];
	                bigSlot[1]=slots1[slotOneStart][1];
	            }else{
	                bigSlot[0]=slots2[slotTwoStart][0];
	                bigSlot[1]=slots2[slotTwoStart][1];
	            }

	            if(slot1Diff<slot2Diff){
	                smallSlot[0]=slots1[slotOneStart][0];
	                smallSlot[1]=slots1[slotOneStart][1];
	            }else{
	                smallSlot[0]=slots2[slotTwoStart][0];
	                smallSlot[1]=slots2[slotTwoStart][1];
	            }

	            if(smallSlot[0]>=bigSlot[0] && smallSlot[1]<bigSlot[1] || smallSlot[1]>=bigSlot[0] && smallSlot[1]<bigSlot[1]){
	                maxStartTime=Math.max(slots1[slotOneStart][0],slots2[slotTwoStart][0]);
	                minEndTime=Math.min(slots1[slotOneStart][1],slots2[slotTwoStart][1]);
	                if(Math.abs(maxStartTime-minEndTime)>=duration) return new int[]{maxStartTime,maxStartTime+duration};
	            }

	            slotOneStart++;
	            slotTwoStart++;

	        }
	        return new int[]{};
	    }

}
