package com.stack_program;
import java.util.Stack;

public class Evalution_of_Postfix_Expression {
	/*
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
	}*/
	

    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack< Integer> stk = new Stack <> () ;
        for ( int i  = 0 ; i < S.length () ; i++ ){
            char ch =  S.charAt(i) ;
            
             if ( ch != '+' &&  ch != '-' && ch!= '*' && ch != '/') { 
                 int char_int = Character.getNumericValue(ch) ;
                stk.push(char_int)  ;
            } 
            else { 
                
              int a =   stk.peek ();
              stk.pop() ;
              
              int b= stk.peek() ;
              stk.pop() ;
                     if ( ch == '+') {
                       int c = a+b ;
                        stk.push(c) ;
                     }
                     else if (ch == '-' ) {
                      int c =  b - a ;  // b - a  because a comes first and on top and b is below a and in postfix function work like this b-a ;
                       stk.push(c) ; 
                     }else if (ch == '*') {
                      int c = b *a  ;
                      stk.push(c) ; }
                      
                       else {
                       int c =  b / a ;
                       stk.push( c ) ;
                    }
               }
            }  
            int c = stk.peek () ;
            return c ; 
        }

	public static void main(String[] args) {
		String S = " ";
		int result = evaluatePostFix(S);
		System.out.println("Result of postfix expression " + S + " is: " + result);
	}
}
