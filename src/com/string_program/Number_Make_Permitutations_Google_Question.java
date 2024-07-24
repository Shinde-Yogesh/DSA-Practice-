package com.string_program;

public class Number_Make_Permitutations_Google_Question {

	public static void main(String[] args) {
		generatePermutations("", "12");
	}

	static void generatePermutations(String currentPermutation, String remainingDigits) {
		// Base case: If there are no more digits to process, print the current
		// permutation
		if (remainingDigits.isEmpty()) {
			System.out.println(currentPermutation);
			return;
		}

		// Convert the first digit character to an integer
		int digit = remainingDigits.charAt(0) - '0';

		// Loop to map the digit to its corresponding letters
		for (int i = (digit - 1) * 3; i < digit * 3; i++) {
			char letter = (char) ('a' + i);
			// Recursively generate permutations with the next digit
			generatePermutations(currentPermutation + letter, remainingDigits.substring(1));
		}
	}
}
