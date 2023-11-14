package com.recursion_program.easy_Level;

public class Binary_Search_On_Array {

	public static int binary_search(int array[], int len, int key) {
		int start = 0;
		int end = len - 1;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (array[mid] == key) {
				return mid;
			}
			// go towards right side
			if (key > array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return -1;
	}
	public static void main(String[] args) {
		int array[] = {1,0,3,5,9,12};
		int len = array.length;
		int key = 9;
		System.out.println(binary_search(array, len, key));
	}

}
