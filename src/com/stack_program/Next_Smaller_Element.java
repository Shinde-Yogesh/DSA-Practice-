package com.stack_program;
import java.util.*;
import java.util.Stack;
public class Next_Smaller_Element {

	static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int arr1[] = new int[n];

        for (int i = arr.size() - 1; i >= 0; i--) {

            int curr = arr.get(i);

            while (!stack.isEmpty() && curr <= stack.peek()) {

                stack.pop();

            }

            arr1[i] = stack.peek();

            stack.push(curr);

        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ans.add(arr1[i]);

        }

        return ans;

    }
    /*
	
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

         // Iterating through all the array elements and finding next smaller element for each element.
   		 for (int i = 0; i < n; i++) {

       	 	// Initializing the next smaller element as -1.
        	ans.add(-1);

        	// Moving to the right of the element.
        	for (int j = i + 1; j < n; j++) {

            	// Checking for the next smaller element.
            	if (arr.get(i) > arr.get(j)) {
					ans.set(i, arr.get(j));
                	break;
            	}
        	}	
    	}

        return ans;
    }
    */

	
	
	
	public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
       list.add(4);
        list.add(3);
       
        System.out.println("Original Stack: " + list);

       

        System.out.print("After the output"+ nextSmallerElement(list,list.size())); 
    }
}
