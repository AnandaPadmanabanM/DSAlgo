package day5;

import org.junit.Assert;
import org.junit.Test;

public class MinFindNumberUsingKandane {

	@Test
	public void tc01() {
		int[] input = {1,2,-1,-3,5,7};
		Assert.assertEquals(findMinusingKandane(input),-4);
	}

	@Test
	public void tc02() {
		int[] input = {};
		Assert.assertEquals(findMinusingKandane(input),"Invalid Input");
	}

	private int findMinusingKandane(int[] input) {
		int windowSum=input[0], min=input[0];
		if(input.length==0) throw new RuntimeException("Invalid Input");
		for (int i = 1; i < input.length; i++) {
			windowSum=Math.min(windowSum+input[i], input[i]); //2
			min=Math.min(min, windowSum); //1
		}
		System.out.println(min);		
		return min;
	}

}
