package com.recursion_program.easy_Level;

public class Recursive_program_for_prime_number {
	public static void main(String[] args) {
		int num = 11;

		if (isPrime(num)) {
			System.out.println(num + " is a prime number.");
		} else {
			System.out.println(num + " is not a prime number.");
		}
	}

	// Recursive method to check if a number is prime
	public static boolean isPrime(int n) {
		return isPrimeRec(n, 2); // Start checking from divisor 2
	}

	private static boolean isPrimeRec(int n, int divisor) {
		// Base cases
		if (n <= 1) {
			return false; // Numbers less than or equal to 1 are not prime
		}
		if (divisor > Math.sqrt(n)) {
			return true; // No divisors found, the number is prime
		}

		// Check if n is divisible by the current divisor
		if (n % divisor == 0) {
			return false; // Found a divisor, the number is not prime
		}

		// Recursive case: Check the next divisor
		return isPrimeRec(n, divisor + 1);
	}
}
/*
  
  							RRT
  			
			  			isPrimeRec(7, 2)
						|-- isPrimeRec(7, 3)
						|   |-- isPrimeRec(7, 4)
						|   |   |-- isPrimeRec(7, 5)
						|   |   |   `-- isPrimeRec(7, 6)
						|   |   |       `-- isPrimeRec(7, 7)
						|   |   |           `-- Result: true
						|   |   `-- Result: true
						|   `-- Result: true
						`-- Result: true

  
  */
