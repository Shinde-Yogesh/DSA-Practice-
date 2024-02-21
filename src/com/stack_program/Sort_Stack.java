package com.stack_program;
import java.util.Stack;
public class Sort_Stack {
	
	
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
	public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(-1);
        stack.push(4);
        stack.push(-5);

        System.out.println("Original Stack: " + stack);

        sort(stack);

        System.out.print("Reversed Stack: "+ " "+stack); 
    }
}
