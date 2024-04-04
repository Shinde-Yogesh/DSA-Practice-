package com.stack_program;

import java.util.Stack;

public class Get_Minimum {
	static Stack<Integer> stack = new Stack<Integer>();
	static int mini;

	public static void push(int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			mini = data;
		} else {
			if (data < mini) {
				stack.push(2 * data - mini);
				mini = data;
			} else {
				stack.push(data);
			}

		}
	}

	int pop() {
		if (stack.isEmpty()) {
			return -1;
		}

		int curr = stack.peek();
		stack.pop();

		if (curr > mini) {
			return curr;
		} else {
			int prevMin = mini;
			int val = 2 * mini - curr;
			mini = val;
			return prevMin;
		}
	}

	int peek() {
		if (stack.isEmpty()) {
			return -1;
		}

		int curr = stack.peek();
		if (curr < mini) {
			return mini;
		} else {
			return curr;
		}
	}

	boolean isEmpty() {
		return stack.isEmpty();
	}

	int getMini() {
		if (stack.isEmpty()) {
			return -1;
		}
		return mini;
	}
	public static void main(String[] args) {
		Get_Minimum stack = new Get_Minimum();
	        Get_Minimum.push(13);
	        Get_Minimum.push(47);
//	        System.out.println(stack.pop()); // Output: 47
	        Get_Minimum.push(8);
//	        stack.pop();
	        System.out.println(stack.getMini()); // Output: 13
	}
}


















/*



import java.util.Stack;
public class Solution {
    static class SpecialStack {
     Stack<Integer> stack = new Stack<>();
     int mini;
        void push(int data) {
            if (stack.isEmpty()) {
			stack.push(data);
			mini = data;
		   }
		    else 
		     {
			if (data < mini) {
				stack.push(2 * data - mini);
				mini = data;
			} else {
				stack.push(data);
			}
		}
    }

        void pop() {
           if (stack.isEmpty()) {
			return -1;
		}

		 int curr = stack.peek();
		 stack.pop();

		if (curr > mini) {
			return curr;
		} else {
			int prevMin = mini;
			int val = 2 * mini - curr;
			mini = val;
			return prevMin;
		 }
        }

        int top() {
           if (stack.isEmpty()) {
			return -1;
		}

		int curr = stack.peek();
		if (curr < mini) {
			return mini;
		} else {
			return curr;
		}
        }

        int getMin() {
          if (stack.isEmpty()) {
			return -1;
		 }
		 return mini;
        }
    };
}

*/