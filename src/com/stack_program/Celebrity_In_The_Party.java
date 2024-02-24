package com.stack_program;

import java.util.Stack;

public class Celebrity_In_The_Party {

	public static int celebrity(int M[][], int n) {
		Stack<Integer> stack = new Stack<Integer>();

		// push all element in the stack
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}

		// step 2
		// get two element and compare them

		while (stack.size() > 1) {
			int a = stack.peek();
			stack.pop();

			int b = stack.peek();
			stack.pop();

			if (knows(M, a, b, n)) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}

		int candidate = stack.pop();
		// step 3 single element in the stack is potential so verify it

		boolean rowCheck = false;
		int zeroCount = 0;

		for (int i = 0; i < n; i++) {
			if (M[candidate][i] == 0) {
				zeroCount++;
			}
		}

		// all zeros
		if (zeroCount == n) {
			rowCheck = true;
		}

		// boolean column check

		boolean colCheck = false;
		int oneCount = 0;

		for (int i = 0; i < n; i++) {
			if (M[i][candidate] == 1) {
				oneCount++;
			}
		}

		if (oneCount == n - 1) {
			colCheck = true;
		}

		if (rowCheck == true && colCheck == true) {
			return candidate;
		} else {
			return -1;
		}
	}

//	private static boolean knows(int M[][],int a, int b,int n) {
//		if(M[a][b] == 1)
//		{
//			return true;
//		}else
//		{
//			return false;
//		}
//		
//	}
	/*
	 * private static boolean knows(int M[][], int a, int b, int n) { return M[a][b]
	 * == 1; }
	 * 
	 * public static void main(String args[]) throws IOException { Scanner sc = new
	 * Scanner(System.in); int t = sc.nextInt(); while(t>0) { int N = sc.nextInt();
	 * int M[][] = new int[N][N]; for(int i=0; i<N; i++) { for(int j=0; j<N; j++) {
	 * M[i][j] = sc.nextInt(); } } System.out.println(new
	 * Celebrity_In_The_Party().celebrity(M,N)); t--; } }
	 * 
	 * public static int findCelebrity(int M[][], int n) { Stack<Integer> stack =
	 * new Stack<Integer>();
	 * 
	 * // push all elements onto the stack for (int i = 0; i < n; i++) {
	 * stack.push(i); }
	 * 
	 * // step 2: get two elements and compare them while (stack.size() > 1) { int a
	 * = stack.pop(); int b = stack.pop();
	 * 
	 * if (knows(M, a, b, n)) { stack.push(b); } else { stack.push(a); } }
	 * 
	 * int candidate = stack.pop();
	 * 
	 * // step 3: single element in the stack is potential, so verify it boolean
	 * rowCheck = true; int zeroCount = 0;
	 * 
	 * for (int i = 0; i < n; i++) { if (M[candidate][i] == 1) { rowCheck = false;
	 * break; } if (M[i][candidate] == 0) { zeroCount++; } }
	 * 
	 * // all zeros if (rowCheck && zeroCount == n) { return candidate; } else {
	 * return -1; } }
	 */

	private static boolean knows(int M[][], int a, int b, int n) {
		return M[a][b] == 1;
	}

	public static void main(String args[]) {

		int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		int[][] sample = { { 0, 1 }, { 1, 0 } };
		int n = 2;
		System.out.println(celebrity(arr, 3));
	}
}
