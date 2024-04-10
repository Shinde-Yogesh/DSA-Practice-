package com.stack_program;
import java.util.Stack;

public class Evalution_of_Postfix_Expression {
	public static int evaluatePostfix(String S) {
		// Create a stack to store operands
		Stack<Integer> stack = new Stack<>();

		// Traverse through each character in the postfix string
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);

			// If the character is an operand (digit), push it onto the stack
			if (Character.isDigit(ch)) {
				stack.push(ch - '0'); // Convert char to int and push onto stack
			} else {
				// If the character is an operator, pop two operands from stack
				int operand2 = stack.pop();
				int operand1 = stack.pop();

				// Perform the operation based on the operator
				switch (ch) {
				case '+':
					stack.push(operand1 + operand2);
					break;
				case '-':
					stack.push(operand1 - operand2);
					break;
				case '*':
					stack.push(operand1 * operand2);
					break;
				case '/':
					stack.push(operand1 / operand2);
					break;
				}
			}
		}
		// The final result will be the only element left in the stack
		return stack.pop();
	}

	public static void main(String[] args) {
		String S = "123+*8-";
		int result = evaluatePostfix(S);
		System.out.println("Result of postfix expression " + S + " is: " + result);
	}
}
