package com.string_program;

public class Permutation_String {
	public static void main(String[] args) {
		generatePermutations("", "abc");
	}
	public static void generatePermutations(String current, String remaining) {
		// Base case: If there are no more characters to process, print the current
		// permutation
		if (remaining.isEmpty()) {
			System.out.println(current);
			return;
		}

		// Extract the first character from the remaining string
		char firstChar = remaining.charAt(0);

		// Insert the first character into every possible position of the current
		// permutation
		for (int i = 0; i <= current.length(); i++) {
			String prefix = current.substring(0, i);
			String suffix = current.substring(i, current.length());

			// Recursively generate permutations with the updated current permutation and
			// remaining characters
			generatePermutations(prefix + firstChar + suffix, remaining.substring(1));
		}
	}
}