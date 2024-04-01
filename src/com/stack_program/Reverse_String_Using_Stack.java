package com.stack_program;
import java.util.Stack;
public class Reverse_String_Using_Stack {
	public static String reverse(String S){
		Stack<Character> str = new Stack<Character>();
		for(char val : S.toCharArray())
		{
			str.push(val);
		}
		
		System.out.println(str);
		String output  = "";
		while(!str.isEmpty())
		{
			output += str.pop();
		}
//		output.trim();
		System.out.println(output);
		return output;
      
    }
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(reverse(str));
	}
}
