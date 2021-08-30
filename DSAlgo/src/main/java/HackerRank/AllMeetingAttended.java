package HackerRank;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class AllMeetingAttended {


	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[][] intervals = {{0,30},{5,10},{15,20}};
		Assert.assertFalse(isAllMeetingsAttended(intervals));
	}

	@Test
	public void testData02() { // Negative
		int[][] intervals= {{7,10},{2,4}};
		Assert.assertTrue(isAllMeetingsAttended(intervals));
	}

	@Test
	public void testData03() { // Edge
		int[][] intervals= {{7,9},{2,4},{5,6}};
		Assert.assertTrue(isAllMeetingsAttended(intervals));
	}
	
	private boolean isAllMeetingsAttended(int[][] intervals) {
	
		
		Arrays.sort(intervals,(a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1]; //end
			else return a[0]-b[0]; //start
		});
		
		for (int i = 0; i < intervals.length-1; i++) {
		    if(intervals[i][1]>intervals[i+1][0]) return false;
		}
		return true;
	}
}
