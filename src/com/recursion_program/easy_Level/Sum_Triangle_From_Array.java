package com.recursion_program.easy_Level;

import java.util.Arrays;

public class Sum_Triangle_From_Array {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5 };
		sum(array);
	}

	public static void sum(int array[]) {
		if (array.length < 1) {
			return;
		}

		int temp[] = new int[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			int next = array[i] + array[i + 1];
			temp[i] = next;
		}

		sum(temp);

		System.out.println(Arrays.toString(array));
	}
}

/// Excalidraw call stack   :-    https://excalidraw.com/#json=VAQg6D7tCB2gkshy2e69C,LxVytjygwQrKLc5LAIlEEg
/*
 * 
 * [48] [20, 28] [8, 12, 16] [3, 5, 7, 9] [1, 2, 3, 4, 5]
 * 
 */