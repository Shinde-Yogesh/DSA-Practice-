package com.stack_program;

import java.util.ArrayList;
import java.util.Stack;

public class Largest_Rectangle_In_Histogram {

	public static int largest(ArrayList<Integer> height)
	{
		int n = height.size();
		
		ArrayList<Integer> next ;
		next = nextSmallestElement(height,n);
		
		
		ArrayList<Integer> prev ;
		prev = prevSmallestElement(height,n);
		
		
		int area = Integer.MIN_VALUE;
		for(int i = 0; i<n;i++)
		{
			int l = height.get(i);
			int b = next.get(i) - prev.get(i) - 1;
			
			if(next.get(i) == -1)
			{
				next.set(i, n) ;
			}
			
			int newArea = l * b;
			area = Math.max(area,newArea);
		}
		return area;
	}

	private static ArrayList<Integer> nextSmallestElement(ArrayList<Integer> arr, int n) {
		 Stack<Integer> stack = new Stack<>();

	        stack.push(-1);

	        int arr1[] = new int[n];

	        for (int i = arr.size() - 1; i >= 0; i--) {

	            int curr = arr.get(i);

	            while (stack.peek() != -1 && curr <= arr.get(stack.peek())) {

	                stack.pop();

	            }

	            arr1[i] = stack.peek();

	            stack.push(i);

	        }

	        ArrayList<Integer> ans = new ArrayList<>();

	        for (int i = 0; i < n; i++) {

	            ans.add(arr1[i]);

	        }

	        return ans;
	}
	private static ArrayList<Integer> prevSmallestElement(ArrayList<Integer> arr, int n) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(-1);
		
		int arr1[] = new int[n];
		
		for (int i = 0; i<n ;i++) {
			
			int curr = arr.get(i);
			
			while (stack.peek() != -1 &&curr <=  arr.get(stack.peek())) {
				
				stack.pop();
				
			}
			
			arr1[i] = stack.peek();
			
			stack.push(i);
			
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			ans.add(arr1[i]);
			
		}
		
		return ans;
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(2);
		list.add(3);
		
		System.out.println(list);
		System.out.println(largest(list));
	}
}
