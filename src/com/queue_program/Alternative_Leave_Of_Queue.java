package com.queue_program;

import java.util.ArrayDeque;
import java.util.Queue;

public class Alternative_Leave_Of_Queue {

	public static void alternative(Queue<Integer> queue) //T.C O(n) S.C O(n)
	{
		//put half of queue in new queue
		int halfSize =( queue.size()/2);
		System.out.println("Orignal queue : "+ queue);
		
		//duplicate queue 
		Queue<Integer> duplicate = new ArrayDeque<>();
		int count = 0;
		while(count != halfSize )
		{
			duplicate.add(queue.peek());
			queue.remove();
			count++;
		}
		System.out.println("Orignal Queue half : "+ queue);
		System.out.println("Duplicate queue : "+ duplicate);
		
		
		//The real Game Begin 
		
		while(!duplicate.isEmpty())
		{
			//duplicate queue first and so on element remove 
			// and add to the old queue
			int value = duplicate.peek();
			duplicate.remove();
			queue.add(value);
			
			//for same operation but the first element remove and
			//add to the last
			
			int sample = queue.peek();
			queue.remove();
			queue.add(sample);
			
		}
		
		System.out.println("After the Operation Queue : "+ queue);
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.add(16);
		queue.add(17);
		queue.add(18);
		
		alternative(queue);
	}
}
