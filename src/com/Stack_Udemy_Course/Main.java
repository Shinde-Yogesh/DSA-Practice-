package com.Stack_Udemy_Course;

public class Main {
	public static void main(String[] args) {
		Stack stack = new Stack(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.getTop();
		stack.getHeight();
		stack.printStack();
		
		stack.pop();
		stack.printStack();
	}

}
