package com.Stack_Udemy_Course;

public class Main {
	public static void main(String[] args) {
//		Stack stack = new Stack(4);
//		stack.push(5);
//		stack.push(6);
//		stack.push(7);
//		stack.push(8);
//		stack.getTop();
//		stack.getHeight();
//		stack.printStack();
//		
//		stack.pop();
//		stack.printStack();
		
		
		// For Queue Class Operation
		Queue queue = new Queue(10);
//		queue.getFirst();
//		queue.getLast();
		
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		queue.getLength();
		queue.printQueue();
		
		System.out.println(queue.dequeue().value);
		queue.getLength();
		queue.printQueue();
		
	}

}
