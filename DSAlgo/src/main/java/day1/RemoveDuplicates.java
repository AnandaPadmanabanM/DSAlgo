package day1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;



public class RemoveDuplicates {
    
//    {2,3,4,5,6}
//    target = 5
//    {2,3,4,6}
//
//    {2,3,4,5,5,6}
//    target = 5
//    {2,3,4,6}
    // Remove target element from the given array
 /*
  *
  * 
  *  Pseudocode
  *  1) Get input integer array
  *  2) Iterate through the array
  *  3) Check for Target value
  *  4)If Found, increment the count of occurrence of target value
  *  5)If not found, move it to the new array
  *  6) Return new array by subtracting the number of occurrences of target value
  *
  */
    
    
    @Test
    public void test1()
    {
     int[] input = {2,3,4,5,6};
     int target = 5;
     
     Assert.assertArrayEquals(removeTargetSinglePass(input,target), new int[]{2,3,4,6});
    }
   @Test
    public void test2()
    {
     int[] input = {5,3,8,5,5,6};
     int target = 5;
     
     Assert.assertArrayEquals(removeTargetSinglePass(input,target), new int[]{3,8,6});
    }
    @Test
    public void test3()
    {
     int[] input = {2,3,4,6};
     int target = 5;
     Assert.assertArrayEquals(removeTargetSinglePass(input,target), input);
    }
    
  
    
    private int[] removeTargetElement(int[] input, int target) {
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) 
        {
            if(input[i] != target) data.add(input[i]);
                
        }
        
        int[] returnData = new int[data.size()];
        for (int i = 0; i < data.size(); i++) 
        {
         returnData[i] = data.get(i);    
        }
        return returnData;
    }
    
    private int[] removeTargetElement1(int[] input, int target) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == target) count++;
        }
        int[] nums = new int[input.length - count];
        for (int i = 0; i < input.length; i++) {
            if (input[i] != target) {
                nums[index++] = input[i];
            }
         }
        return nums;
    }
    
    private int[] removeTargetElement2(int[] input, int target) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == target) count++;
        }
        if(count == 0)
        	return input;
        int[] nums = new int[input.length - count];
        count=0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != target) {
                nums[count++] = input[i];
            }
         }
        return nums;
    }
    
    private int[] removeTargetSinglePass(int[] input, int target) {
    	
    	 int index =0;
    	 int count=0;
    	 
    	 int out[]= new int[input.length]; //O(n)
    	 
    	 for(int i=0; i<input.length;i++) {  //O(n)
			 
				if(input[i] != target)
				{					
					out[index++]=input[i];
					
				}
				else
				{
					count++;
				}
				 		 
		 }
        out = Arrays.copyOfRange(out, 0, out.length-count);
        System.out.println(Arrays.toString(out));
		return out;
    }
    
    // Time Complexity - O(n)
    //Space Complexity - O(n)
    
}