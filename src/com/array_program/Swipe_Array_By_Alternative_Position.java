package com.array_program;

public class Swipe_Array_By_Alternative_Position {
	public static void swapArray(int array[], int size) {
		for (int i = 0; i < size; i += 2) {  
			if (i + 1 < size) {
				swap(array, i, i + 1);  // Pass the array and indices to swap
			}
		}
	}

	private static void swap(int[] array, int i, int j) {  // Accept array and indices
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void print(int array[]) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();  // Add a newline for better readability
	}

	public static void main(String[] args) {
		int even[] = { 5, 2, 9, 4, 7, 6, 1, 0 };
		int size = even.length;
		int odd[] = { 11, 23, 9, 76, 43 };
		System.out.println("Before the method call ");
		print(even);
		
		System.out.println("After the method call ");
		swapArray(even, size);
		print(even);

		System.out.println("Before the method call ");
		print(odd);
		
		System.out.println("After the method call ");
		swapArray(odd, odd.length);
		print(odd);
	}
}
