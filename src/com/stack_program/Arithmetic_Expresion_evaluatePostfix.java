package com.stack_program;
import java.util.PriorityQueue;
import java.util.Stack;

public class Arithmetic_Expresion_evaluatePostfix {
	 // Function to evaluate the postfix expression
    public static double evaluatePostfix(String expression) {
    	expression = expression.replaceAll(" ","" );
    	
    	// creating the priority Queue
    	 PriorityQueue<Character> pQueue = new PriorityQueue<Character>();
    	 
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is a digit, push it onto the stack
            if (Character.isDigit(c)) {
            	if(c == '(' || c == ')') continue ;
                stack.push((int)(c - '0'));
            } else {
                // If the character is an operator, pop the top two operands and perform the operation
                int	  operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(c, operand1, operand2);
                
                // Push the result back onto the stack
                stack.push((int)result);
            }
        }
        
        // The final result is at the top of the stack
        return stack.pop();
    }
    
    // Function to perform arithmetic operations
    public static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    public static void main(String[] args) {
        String postfixExpression = "2 4 + 4 6 + *";
        double result = evaluatePostfix(postfixExpression);
        System.out.println("Result of expression " + postfixExpression + " is: " + result);
    }
}
