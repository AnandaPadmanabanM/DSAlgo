package day7;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

public class ProductProblem {


	@Test
	public void test1() {
		int[] nums = {1,2,3,4};
		Assert.assertTrue(Arrays.equals(findProduct(nums), new int[] {24,12,8,6}));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,0};
		Assert.assertTrue(Arrays.equals(findProduct(nums), new int[] {0,0,2}));
	}

	private int[] findProduct(int[] nums) {
		int count=0;
		int[] out = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int product =1;
			for (int j = 0; j < nums.length; j++) {
				if(i!=j) {
					product*=nums[j];
				}
			}
			out[count++]=product;
		}	
		System.out.println(Arrays.toString(out));
		return out;
	}
}
