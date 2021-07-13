package day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindInterSectionElement {

	/*
	 * Que- Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must be unique and you may return
	 * the result in any order.
	 * 
	 * Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Problem
	 * solving template 1. Did I understand the problem? yes or no If no ask the
	 * person to provide with more details with examples If yes go to the next step
	 * What is the input(s)? - two input arrays What is the expected output? -
	 * integer array Do I’ve constraints to solve the problem? Do Ive all the
	 * information to go to the next steps How big is your test data set will be? 2.
	 * Test data set Minimum 3 data set including positive, negative and edge
	 * Validate with the interviewer if the data set is fine by his/ her assumptions
	 * 3. Do I know to solve it? Yes- great is there an alternate ? No - can I break
	 * the problem into sub problems? 4. Ask for hint (if you don’t know how to
	 * solve this 5. Do I know alternate solutions as well Yes- what are those? No-
	 * that is still fine, proceed to solve by what you know Simple technique brute
	 * force 6. If you know the alternate solution find out the O-notations
	 * (performance) 7. Then, explain either both are the best (depends on the time)
	 * Approach 1:- start with the worst-> improve (optimize) -> End up with the
	 * best Approach 2: Write down the options and benefits and code the best 8.
	 * Start always with the Pseudo code 9. Test against different test data 10. If
	 * it fails then debug to solve it
	 * 
	 * Constraints:No Sort Pseudo code: 1. Compare two arrays to find the common
	 * elements 2. If found, add it to the set 3. Return common elements as array
	 * 
	 * Complexity: Time - O(n) Space - O(n)
	 */

	@Test
	public void test1() {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		Integer[] output = findInterSection(nums1, nums2);
		Assert.assertEquals(output, new Integer[] { 2,2 });
	}

	@Test
	public void test2() {
		int[] nums1 = { 1, 2, 2, 1, 3, 4, 3 };
		int[] nums2 = { 2, 2, 3, 6, 4 };
		Integer[] output = findInterSection(nums1, nums2);
		Assert.assertEquals(output, new Integer[] { 2,2,3,4 });
	}

	@Test
	public void test3() {
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		Integer[] output = findInterSection(nums1, nums2);
		Assert.assertEquals(output, new Integer[] {});
	}

	@Test
	public void test4() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		Integer[] output = findInterSection(nums1, nums2);
		Assert.assertEquals(output, new Integer[] {4,9});
	}

	private Integer[] findInterSection1(int[] nums1, int[] nums2) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					set.add(nums2[j]);
				}
			}
		}
		Integer[] arr = new Integer[set.size()];

		Integer[] array = set.toArray(arr);
		System.out.println(Arrays.toString(array));

		return set.toArray(arr);
	}

	private Integer[] findInterSection(int[] nums1, int[] nums2) {

		if (nums1.length < 1 && nums2.length < 1)
			throw new RuntimeException("Invalid Input");

		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int index1 = 0, index2 = 0;
		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] == nums2[index2]) {
				list.add(nums1[index1]);
				index1++;
				index2++;

			} else if (nums1[index1] < nums2[index2]) {
				index1++;
			} else {
				index2++;
			}
		}
		Integer[] arr = new Integer[list.size()];
		return list.toArray(arr);
	}

}