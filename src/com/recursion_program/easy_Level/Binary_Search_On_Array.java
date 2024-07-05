package com.recursion_program.easy_Level;

import java.util.Arrays; // Importing Arrays to sort the array

public class Binary_Search_On_Array {

    public static int binary_search(int array[], int len, int key) {
        int start = 0;
        int end = len - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (array[mid] == key) { // Check if the mid element is the key
                return mid;
            }
            // Go towards the right side if the key is greater
            if (key > array[mid]) {
                start = mid + 1;
            } else { // Go towards the left side if the key is smaller
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1; // Key not found
    }

    public static void main(String[] args) {
        int array[] = {1, 0, 3, 5, 9, 12}; // Initial array
        Arrays.sort(array); // Sorting the array to use binary search
        int len = array.length;
        int key = 9;
        System.out.println(binary_search(array, len, key)); // Expected output: Index of 9 in the sorted array
    }
}
