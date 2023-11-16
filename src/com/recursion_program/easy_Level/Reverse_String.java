package com.recursion_program.easy_Level;

public class Reverse_String {

	// Iterative approach
	public static String reverseStringIterative(String str) {
		char[] charArray = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			// Swap characters at start and end indices
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;

			// Move indices towards each other
			start++;
			end--;
		}

		return new String(charArray);
	}

	public static String reverseStringRecursive(String str) {
		// Base case: if the string is empty or has only one character
		if (str.length() <= 1) {
			return str;
		}
		System.out.println(str);
		// Recursive case: reverse the substring excluding the first character
		// and concatenate the first character at the end
		return reverseStringRecursive(str.substring(1)) + str.charAt(0);
	}

	public static void main(String[] args) {
		String s = "NOVEMBER";
		System.out.println(reverseStringRecursive(s));
	}
}
