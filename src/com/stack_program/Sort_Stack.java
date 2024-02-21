package com.stack_program;
import java.util.Stack;
public class Sort_Stack {
	
	// Approch 1
	/*
	public static void sort(Stack<Integer> stack)
	{
		// check the base condition
		if(stack.isEmpty())
		{
			return;
		}
		
		int num = stack.pop();
		
		
		//recurstive call
		sort(stack);
		
		//in condition true we want to insert the pop value in sorted way
		sortedInsert(stack,num);
	}

	private static void sortedInsert(Stack<Integer> stack, int num) {
		//base case 
		if((stack.isEmpty()) || (stack.peek() < num))
		{
		stack.push(num);
		return;
		}
		int n = stack.pop();
		
		//recursive call
		sortedInsert(stack, num);
		stack.push(n);
	}
	*/
	
	
	public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(-1);
        stack.push(4);
        stack.push(-5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.print("Reversed Stack: "+ " "+stack); 
    }
	
	//Approach 2
	public static void sortedInsert(Stack<Integer> stack, int current) {
		if (stack.empty() == true || current > stack.peek()) {  // (stack.empty() == true || current < stack.peek()) for the desc stack
			stack.push(current);
			return;
		}

		// Remove the top element
		int top = stack.peek();
		stack.pop();
		// Recursion for the remaining elements in the stack
		sortedInsert(stack, current);
		// Insert the popped element back in the stack
		stack.push(top);
	}

	// Recursive method to sort a stack
	public static void sortStack(Stack<Integer> stack) {
		// Base case: stack is empty
		if (stack.empty() == true) {
			return;
		}

		// Remove the top element
		int top = stack.peek();
		stack.pop();
		// Recursion for the remaining elements in the stack
		sortStack(stack);
		// Insert the popped element back in the sorted stack
		sortedInsert(stack, top);
	}
}
