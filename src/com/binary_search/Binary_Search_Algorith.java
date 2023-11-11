package com.binary_search;

public class Binary_Search_Algorith {

	public static int binary_search(int array[], int len, int key) {
		int start = 0;
		int end = len - 1;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (array[mid] == key) {
				return mid;
			}

			// go towords right side

			if (key > array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Program is running ");

		int evenArray[] = { 2, 4, 6, 8, 12, 18 };
		int length  = evenArray.length;
		int key =12;
		
		
		int oddArray[] = {3,8,11,14,16};

		int index = binary_search(evenArray, length, key);
		System.out.println("index of "+ key +" is " + index);
	}

}
