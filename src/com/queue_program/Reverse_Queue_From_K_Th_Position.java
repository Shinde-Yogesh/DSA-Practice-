package com.queue_program;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Queue_From_K_Th_Position {
	 public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
		
		 //Create the stack
		 Stack<Integer> stack = new Stack<Integer>();
		 
//		 push the kth element into the queue
		 for(int i = 0;i<k;i++)
		 {
			 int val = q.remove();
			
			 stack.push(val);
		 }
		 
//		 step 2 : fetch from the stack and push into queue
		 while(!stack.isEmpty())
		 {
			 int val = stack.peek();
			 stack.pop();
			 q.add(val);
		 }
		 
		 //step 3 : fetch the first (k-n) element from Queue and push back
		int t = q.size()-k;
		 while(t != 0)
		 {
			 int val=  q.remove();
			 q.add(val);
			 t--;
		 }
		 
		 return q;
	    }
	 public static void main(String[] args) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>( List.of(1, 2, 3, 4, 5));
		int k = 3;
		System.out.println("Before the operation on the queue : "+queue);
		modifyQueue(queue,k);
		System.out.println("After the operation on the queue : "+queue);
	}
}
