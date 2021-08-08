package day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LC128_FindLongestConsequtiveSeq {

	
	
@Test
public void tc01(){
	int[] nums= {100,4,200,1,3,2};
	Assert.assertTrue(findLongestSeq(nums)==4);
	
}

@Test
public void tc02(){
	int[] nums= {100,4,200,1,7,9};
	Assert.assertTrue(findLongestSeq(nums)==1);
	
}

@Test
public void tc03(){
	int[] nums= {100,-4,200,1,-3,9};
	Assert.assertTrue(findLongestSeq(nums)==2);
	
}

private int findLongestSeq(int[] nums) {
	int max=0;
	HashMap<Integer, Boolean> map=new HashMap<>();
	for (int i :nums) {
		map.put(i, true);
	}
	
	for(int i : nums) {
		if(map.containsKey(i-1)) {
			map.put(i, false);
		}
	}
	
	for(int i : nums) {
		int count=0;
		if(map.get(i)) {
			while(map.containsKey(i)) {
				count++;
				i++;
			}
			
			max=Math.max(max,count);
		}
	}
			
	return max;	
	
}
	
	
}
