package day1;

import java.util.Arrays;

import org.junit.Test;

public class SumProblem {
	
	/*
	 * 1)	Did I understand the problem? Yes or No !! 
	 * 		-> If No, Ask the person to provide more detail with example(s) 
	 * 		-> If yes, go to next step !! 
	 * 
	 *  
	 *  What is the input(s)? 
	 *  What is the expected output? 
	 *  Do I have constraints to solve the problem? 
	 *  Do I have all informations to go to next step!! 
	 *  How big is your test data set will be?
	 * 
	 *  
	 *  2) Test Data Set
	 *   	-> Positive, Negative, Edge
	 *   
	 *  3)DO I know to solve it?
	 *   	-> Yes- check for alternate solution
	 *   	-> No - Check for feasibility to break down into sub problems
	 *   
	 *  4)Ask for hint
	 *  
	 *  5)Do I know alternate solutions?
	 *  	-> Yes - what are those?
	 *  	-> No - it's okay to proceed with what you know 
	 * 	
	 *   Approach Taken:
	 * 	1) Yes	 	
	 *  2) positive -> i/p1-> {3,5,4,4,8} i/p2 ->8   o/p ->{0,1},{2,3} { (first match | All matches)
	 *     negative -> i/p1-> {3,5,4,4,8} i/p2 ->15  what should return?
	 *     edge -> i/p1-> {3,5,4,4,8} i/p2 ->10   o/p ->{1,1}
	 *  3) yes  
	 *  4) Not required
	 *  5) Brute force
	 */

	//+ve
    @Test
    public void test(){
        int [] nums={1,4,2,8,2,6};
        int k=10;
        int[] ints = returnIndex(nums, k);
        System.out.println(Arrays.toString(ints));
    }
    //-ve
    @Test
    public void test1(){
        int [] nums={1,4,2,8,2,6};
        int k=110;
        int g=110;
        int[] ints = returnIndex(nums, k);
        System.out.println(Arrays.toString(ints));

    }

    @Test
    public void test2(){
        int [] nums={1,4,2,8,2,6};
        int k=10;
        int[] ints = twoSum(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] returnIndex(int [] nums, int k){
        for (int i=0;i<nums.length;i++){
            int diff=k-nums[i];
            if (nums[i]==k)
                return new int[]{i,i};
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]==diff){
                    return new int[]{i,j};

                }
            }

        }
        return new int[]{-1,-1};
    }

    public int[] twoSum(int [] nums, int k){
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==k)
                return new int[]{left,right};
            else if(nums[left]+nums[right]>k)
                right--;
            else
                left++;
        }
        return new int[]{-1,-1};
    }



}
