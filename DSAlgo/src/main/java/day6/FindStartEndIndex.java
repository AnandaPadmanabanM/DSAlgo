package day6;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindStartEndIndex {
	

	@Test
	public void testData01(){            // Positive
		int[] input = {12,-90,-100,15,98,12,-56};
		int target = 12;
		Assert.assertTrue(Arrays.equals(searchRange(input,target),
				new int[]{0,5}));
	}
	
	
	
	 public int[] searchRange(int[] nums, int target)
	    {
	        int low = 0;
	        int high = nums.length-1;
	        int[] res = {-1,-1};
	        String val="";
	        val.substring(low, high);

	        if (nums.length == 0) { return res; }
	        
	        helper(nums, target, low, high, res);
	        
	        // case where only one target exist.
	        if (res[1] == -1) { res[1] = res[0]; }
	        
	        return res;
	    }
	    
	    public void helper(int[] nums, int target, int low, int high, int[] res)
	    {
	        if(low > high) { return; }
	        
	        int mid = (low + high)/2;
	        
	        helper(nums, target, low, mid-1, res);

	        // if found, put into index 0 if first.
	        // put into index 1 any ever time after.
	        if (nums[mid] == target && res[0] == -1) { res[0] = mid; }
	        if (nums[mid] == target && res[0] != -1) { res[1] = mid; }
	        
	        helper(nums, target, mid+1, high, res);
	    }
}
