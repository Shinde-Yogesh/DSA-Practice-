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
        //add code here.
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
		
		System.out.println("Afte the reverse the Opertaion : " +rev(queue));
	}
}
