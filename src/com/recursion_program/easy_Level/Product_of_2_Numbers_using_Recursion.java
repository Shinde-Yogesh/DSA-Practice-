package com.recursion_program.easy_Level;

public class Product_of_2_Numbers_using_Recursion {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 5;

		int result = multiply(num1, num2);
		System.out.println("Product of " + num1 + " and " + num2 + " is: " + result);
	}

	// Recursive method to calculate the product of two numbers
	public static int multiply(int a, int b) {
		// Base case: If one of the numbers is 0, return 0
		if (a == 0 || b == 0) {
			return 0;
		}

		// Recursive case: a * b = a + a * (b-1)
		return a + multiply(a, b - 1);
	}
}

/*
 * Input : x = 5, y = 2 Output : 10
 * 
 * Input : x = 100, y = 5 Output : 500
 * 
 */
/* 

			RRT
			multiply(3, 4)
			|-- 3 + multiply(3, 3)
			|   |-- 3 + multiply(3, 2)
			|   |   |-- 3 + multiply(3, 1)
			|   |   |   |-- 3 + multiply(3, 0)  // Base case: b == 0
			|   |   |   |   `-- Result: 0
			|   |   |   `-- Result: 3
			|   |   `-- Result: 6
			|   `-- Result: 9
			`-- Result: 12				


*/
