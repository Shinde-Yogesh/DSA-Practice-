package com.recursion_program.easy_Level;

public class Recursive_Bubble_Sort {
	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		int n = arr.length;

		System.out.println("Original Array:");
		printArray(arr);

		bubbleSort(arr, n);

		System.out.println("\nSorted Array:");
		printArray(arr);
	}

	// Recursive Bubble Sort
	public static void bubbleSort(int[] arr, int n) {
		if (n == 1) {
			return; // Base case: Array with one element is already sorted
		}

		// One pass of bubble sort. After this pass, the largest element is at the end.
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				// Swap arr[i] and arr[i+1]
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

		// Recursive call with the reduced size of the array
		bubbleSort(arr, n - 1);
	}

	// Utility method to print an array
	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}


/*

								RRT

							bubbleSort([64, 34, 25, 12, 22, 11, 90], 7)
							|-- bubbleSort([34, 25, 12, 22, 11, 64, 90], 6)
							|   |-- bubbleSort([25, 12, 22, 11, 34, 64, 90], 5)
							|   |   |-- bubbleSort([12, 22, 11, 25, 34, 64, 90], 4)
							|   |   |   |-- bubbleSort([12, 11, 22, 25, 34, 64, 90], 3)
							|   |   |   |   |-- bubbleSort([11, 12, 22, 25, 34, 64, 90], 2)
							|   |   |   |   |   |-- bubbleSort([11, 12, 22, 25, 34, 64, 90], 1)  // Base case
							|   |   |   |   |   `-- Result: [11, 12, 22, 25, 34, 64, 90]
							|   |   |   |   `-- Result: [11, 12, 22, 25, 34, 64, 90]
							|   |   |   `-- Result: [11, 12, 22, 25, 34, 64, 90]
							|   |   `-- Result: [11, 12, 22, 25, 34, 64, 90]
							|   `-- Result: [11, 12, 22, 25, 34, 64, 90]
							`-- Result: [11, 12, 22, 25, 34, 64, 90]

*/