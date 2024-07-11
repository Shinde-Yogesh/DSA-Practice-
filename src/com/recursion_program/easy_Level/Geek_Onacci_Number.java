package com.recursion_program.easy_Level;

import java.util.Scanner;
import java.util.HashMap;

public class Geek_Onacci_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			

			HashMap<Integer, Integer> memo = new HashMap<>();
			int ans = geekOnacci(a, b, c, n, memo);
			System.out.println(ans);
		}
		sc.close();
	}

	public static int geekOnacci(int a, int b, int c, int n, HashMap<Integer, Integer> memo) {
		if (n == 1)
			return a;
		if (n == 2)
			return b;
		if (n == 3)
			return c;
		if (memo.containsKey(n))
			return memo.get(n);
		int result = geekOnacci(a, b, c, n - 1, memo) + geekOnacci(a, b, c, n - 2, memo) + geekOnacci(a, b, c, n - 3, memo);
		memo.put(n, result);
		return result;
	}
}


/*
 * 
 * 
						 *           RRT
						 * geekOnacci(1, 2, 3, 4)
						|-- geekOnacci(1, 2, 3, 3)
						|   |-- geekOnacci(1, 2, 3, 2)
						|   |   |-- geekOnacci(1, 2, 3, 1)
						|   |   |   `-- Result: 1
						|   |   |-- geekOnacci(1, 2, 3, 2)
						|   |   |   `-- Result: 2
						|   |   `-- Result: 3
						|   |-- geekOnacci(1, 2, 3, 3)
						|   |   `-- Result: 6
						|   `-- Result: 11
						|-- geekOnacci(1, 2, 3, 2)
						|   |-- geekOnacci(1, 2, 3, 1)
						|   |   `-- Result: 1
						|   |-- geekOnacci(1, 2, 3, 2)
						|   |   `-- Result: 2
						|   `-- Result: 3
						|-- geekOnacci(1, 2, 3, 1)
						|   `-- Result: 1
						`-- Result: 6
 * 
 * */
