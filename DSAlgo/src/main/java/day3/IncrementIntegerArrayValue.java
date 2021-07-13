package day3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class IncrementIntegerArrayValue {

	@Test
	public void tc1() {

		int[] nums = { 9, 9, 9, 6 };
		Integer[] addOneToInteger = addOneToInteger(nums);

		Assert.assertEquals(addOneToInteger(nums), new Integer[] {9, 9, 9, 7});

	}

	private Integer[] addOneToInteger(int[] nums) {

		int length = nums.length;
		int sum = 0, carry = 1;
		List<Integer> result = new LinkedList<>();

		if (length < 1)
			throw new RuntimeException("Invalid Input");

		for (int i = length - 1; i >= 0; i--) {

			sum = nums[i] + carry;
			carry = (sum > 9) ? 1 : 0;
			result.add(0, sum % 10);
		}

		if (carry > 0)
			result.add(0, 1);

		Integer[] arr = new Integer[result.size()];
		result.toArray(arr);

		System.out.println(Arrays.toString(arr));
		
		return arr;

	}

}
