package QueueProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import org.junit.Test;

public class InterleavingQueue {
	
	  @Test
	    public void test1() {
	        int[] data = {1,2,3,4,11,12,13,14};
	        // {1,11,2,12,3,13,4,14}
	        
	        System.out.println(Arrays.toString(arrangeInterleaving(data)));
	        
	    }
	  
	  @Test
	    public void test2() {
	        int[] data = {1,3,5,7,2,4,6,8};
	        // {1,2,3,4,5,6,7,8}
	        
	        System.out.println(Arrays.toString(arrangeInterleaving(data)));
	        
	        
	    }

	private int[] arrangeInterleaving(int[] data) {
		ArrayDeque<Integer> queue = new ArrayDeque<> ();
		int window=data.length/2;
		for(int i=0; i<window;i++) {		
			queue.offer(data[i]);
			queue.offer(data[i+window]);
		}	
		int i=0;
		while(!queue.isEmpty()) {
			data[i++]=queue.pollFirst();
		}
		return data;
	}

}
