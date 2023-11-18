package com.recursion_program.easy_Level;

import java.util.Scanner;

public class Special_Fibonacci_Sankalp {

	 // Recursive method to calculate f(n)
    public static int calculateF(int a, int b, int n) {
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            // Use bitwise XOR to calculate f(n)
            return calculateF(b, a ^ b, n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            // Input a, b, and n for each test case
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();

            // Calculate and output f(n) for each test case
            int result = calculateF(a, b, n);
            System.out.println(result);
        }

        scanner.close();
    }
}
