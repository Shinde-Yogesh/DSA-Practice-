package com.stack_program;

import java.util.Stack;

public class Insert_At_Bottom {
	// Function to insert a character at the bottom of the stack
	static void insertAtBottom(Stack<Character> st, char x) {
		if (st.isEmpty()) {
			// If the stack is empty, directly push the character
			st.push(x);
		} else {
			// Remove the top element from the stack
			char a = st.pop();
			// Recursively insert x at the bottom of the stack
			insertAtBottom(st, x);
			// Push the removed element back onto the stack
			st.push(a);
		}
	}
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();

		// Example usage
		stack.push('A');
		stack.push('B');
		stack.push('C');

		System.out.println("Stack before insertion: " + stack);

		// Character to be inserted at the bottom
		char toInsert = 'X';

		// Insert 'X' at the bottom of the stack
		insertAtBottom(stack, toInsert);

		System.out.println("Stack after insertion: " + stack);
	}
}
