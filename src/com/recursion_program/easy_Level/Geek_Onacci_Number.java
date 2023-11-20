package com.recursion_program.easy_Level;

import java.util.Scanner;

public class Geek_Onacci_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int n = sc.nextInt();

			int ans = geekOnacci(a, b, c, n);
			System.out.println(ans);
		}
	}

	public static int geekOnacci(int a, int b, int c, int n) {
		if (n == 1)
			return a;
		if (n == 2)
			return b;
		if (n == 3)
			return c;
		return geekOnacci(a, b, c, n - 1) + geekOnacci(a, b, c, n - 2) + geekOnacci(a, b, c, n - 3);
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
