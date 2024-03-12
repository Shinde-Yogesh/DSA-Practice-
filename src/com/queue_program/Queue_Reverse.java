package com.queue_program;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue_Reverse {
	
	//creating the the stack approach
	
	public static Queue<Integer> rev(Queue<Integer> q){
		
		//crating the stack
		//remove the single element of the queue
		// and add to the stack Until queue is not empty
		Stack<Integer> stack =new Stack<Integer>();
		
		while(!q.isEmpty())
		{
			int element = q.peek();
			q.remove();
			stack.push(element);
		}
		
		//for insert the reverse the element into queue
		//remove the element from the stack push back into the queue
		while(!stack.isEmpty())
		{
			int element  = stack.peek();
			stack.pop();
			q.add(element);
		}		
		return q;
       //Time complexity : O(n)
		//Space complexity : O(n)
    }
	
	//reverse the queue using recursion
	
	public static Queue<Integer> revUsingRecursion(Queue<Integer> q){
		//base case
		//until the queue is not empty
		if(q.isEmpty())
		{
			return q;
		}
		//remove the first element of queue 
		//and call to the recursion
		int element = q.remove();
		rev(q);
		
		//after the queue is empty then the base case reach
		//after the return the value add to the queue
		q.add(element);
		
		return q;
		//Time complexity : O(n)
		//Space complexity : O(n)
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(4);
		queue.add(3);
		queue.add(1);
		queue.add(10);
		queue.add(2);
		queue.add(6);
		System.out.println("Before the Reverse Operation : "+queue);
		
		System.out.println("Afte the reverse the Opertaion : " +revUsingRecursion(queue));
	}
}
