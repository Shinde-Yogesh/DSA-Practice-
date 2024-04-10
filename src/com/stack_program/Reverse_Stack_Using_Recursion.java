package com.stack_program;

import java.util.Stack;

public class Reverse_Stack_Using_Recursion {

	public static void reverseStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			// Remove the top element
			int temp = stack.pop(); // Reverse the remaining stack

			reverseStack(stack); // Insert the top element at the bottom
			insertAtBottom(stack, temp);
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int value) {
		if (stack.isEmpty()) { // If the stack is empty, insert the value
			stack.push(value);
		} else {
			// Remove the top element

			int temp = stack.pop();
			// Recursively insert the value at thebottom

			insertAtBottom(stack, value);
			// Push back the removed element
			stack.push(temp);

		}

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println("Original Stack: " + stack);
		reverseStack(stack);
		System.out.print("Reversed Stack: " + stack);
	}
}
