package com.recursion_program.easy_Level;

public class First_UpperCase_Letter_String {
	public static char checkUpper(String str) {
		String clone = str;
		clone = clone.toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == clone.charAt(i)) {
				// System.out.println(str.charAt(i));
				return str.charAt(i);
			}
		}
		return 0;
	}

	// Iterative approach
	public static char findFirstUppercaseIterative(String str) {
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return c;
			}
		}
		return '\0'; // Return '\0' if no uppercase letter is found
	}

	public static char findFirstUppercaseRecursive(String str, int index) {
		// Base case: If the entire string is traversed and no uppercase letter is found
		if (index == str.length()) {
			return '\0';
		}

		// Check if the current character is uppercase
		if (Character.isUpperCase(str.charAt(index))) {
			System.out.println(index);
			return str.charAt(index);
		}

		// Recursively check the rest of the string
		return findFirstUppercaseRecursive(str, index + 1);
	}

	public static void main(String[] args) {
		String str = "geekS";
		System.out.println(findFirstUppercaseRecursive(str, 0));
	}

}
