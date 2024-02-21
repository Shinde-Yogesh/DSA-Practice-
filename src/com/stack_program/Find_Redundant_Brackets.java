package com.stack_program;

import java.util.Stack;

public class Find_Redundant_Brackets {

	public static boolean findRedundantBrackets(String s)
	{
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (ch == '(' || ch == '+' || ch == '*' || ch == '/' || ch == '-') {

				st.push(ch);

			} else if (ch == ')') {

				if (st.peek() == '(') {

					return true;

				} else {
					 // Pop until an opening bracket is found

					while (st.peek() != '(') {

						st.pop();

					}

				}

				st.pop();  // Pop the opening bracket

			}

		}

		return false;

	}
	/*
	 Approach 2
	 
	 import java.util.Stack;

public class RedundantBrackets {

    public static boolean hasRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                return true; // Found a pair of redundant brackets
            } else if (isOperator(ch) || ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // Pop until an opening bracket is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop(); // Pop the opening bracket
            }
        }

        return false; // No redundant brackets found
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        String expression1 = "((a+b))";
        String expression2 = "(a + (b*c))";

        System.out.println("Expression 1 has redundant brackets: " + hasRedundantBrackets(expression1));
        System.out.println("Expression 2 has redundant brackets: " + hasRedundantBrackets(expression2));
    }
}

	 
	 
	 
	 
	 */

	public static void main(String[] args) {
		String str = "(a+b)";
		System.out.println(findRedundantBrackets(str));
	}
}
