package QueueProblems;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class QueueProblem {

	
	@Test
	public void testData01() // positive
	{
		int[] input ={1,2,3,4,5,6};
		int k=2;

		System.out.println(queuePartialRotate(input,k));
	}
	
	@Test
	public void testData02() // positive
	{
		int[] input ={3,4,5,6};
		int k=4;

		System.out.println(queuePartialRotate(input,k));
	}

	private Queue<Integer> queuePartialRotate(int[] input, int k) {
		
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new ArrayDeque<> ();
		Queue<Integer> finalQueue = new ArrayDeque<> ();
		
		for(int i=0; i<k;i++) {
			stack.push(input[i]);
		} 
		
		for(int j=k; j<input.length;j++ ) {
			queue.offer(input[j]);				
		}
		
		int size = stack.size();
		for(int i=0; i<size;i++ )
		{
			finalQueue.offer(stack.pop());
		}
		
		for (Integer integer : queue) {
			finalQueue.offer(queue.poll());
		}
		
		return finalQueue;
	}

}
