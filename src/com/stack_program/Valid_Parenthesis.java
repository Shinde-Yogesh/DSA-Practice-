package com.stack_program;
import java.util.Stack;
public class Valid_Parenthesis {
	//Function to check if brackets are balanced or not.
    static boolean ispair(String x)
    {
        // add your code here
    
    Stack<Character> stack = new Stack<>();
    int count = 0;
		for (char c : x.toCharArray()) {
			if (c == '(') 
			{count++;
				stack.push(')');
				
			} 
			else if (c == '{') 
			{
				stack.push('}');
				
			} else if (c == '[') 
			{
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c)
			{
				return false;
			}
		}
		System.out.println(count);
		return stack.isEmpty();
    }
    public static void main(String[] args) {
//		String str = "{([])}";
		String str = "(()(";
		System.out.println(ispair(str));
	}

}
