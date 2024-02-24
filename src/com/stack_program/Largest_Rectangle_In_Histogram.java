package com.stack_program;

import java.util.ArrayList;
import java.util.Stack;

public class Largest_Rectangle_In_Histogram {

	/*
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
	*/
	
	
	public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = nextSmallestElement(heights, n);
        int[] prev = prevSmallestElement(heights, n);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = next[i] - prev[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int[] nextSmallestElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];

            while (!stack.isEmpty() && curr <= arr[stack.peek()]) {
                stack.pop();
            }

            result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }

    private static int[] prevSmallestElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int[] result = new int[n];

        for (int i = 0; i < n-1; i++) {
            int curr = arr[i];

            while (!stack.isEmpty() && curr <= arr[stack.peek()]) {
                stack.pop();
            }

            result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(2);
//		list.add(1);
//		list.add(5);
//		list.add(6);
//		list.add(2);
//		list.add(3);
//		
//		System.out.println(list);
//		System.out.println(largest(list));
		
		  int[] heights = {2, 1, 5, 6, 2, 3};
		  System.out.println("Input heights: " + java.util.Arrays.toString(heights));
	      System.out.println("Largest rectangle area: " + largestRectangleArea(heights));
	}
}
