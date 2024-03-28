package com.stack_program;

import java.util.Stack;

public class Middle_Element_of_Stack {

	public static void middle_element(Stack<Integer> s, int sizeOfStack) {
		int mid = (sizeOfStack + 1) / 2;

		if (s.size() == mid) {
			s.pop();
		} else {
			int tmp = s.pop();
			middle_element(s, sizeOfStack);
			s.push(tmp);
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		middle_element(stack,stack.size());
	}
}
