package com.stack_program;
import java.util.Stack;
public class Longth_Logest_Valid_SubString {
	 static int findMaxLen(String S) {
	        // code here
	        int res = 0; 
	        Stack<Integer> st = new Stack<>();
	        
	        st.push(-1);
	        for (int i=0;i<S.length();i++){
	            if (S.charAt(i) == '(') 
	            st.push(i);
	            else {
	                if (!st.isEmpty()) st.pop();
	                if (st.isEmpty()) 
	                   st.push(i);
	                else
	                    res = Math.max(res,i-st.peek());
	            }
	        }
	        return  res;
	    }
	 public static void main(String[] args) {
		String s = "(()(";
		System.out.println(findMaxLen(s));
	}
}
