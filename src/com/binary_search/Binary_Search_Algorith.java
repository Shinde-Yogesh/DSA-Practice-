package com.binary_search;

public class Binary_Search_Algorith {

    public static int binarySearch(int arr[], int length, int target) {
        int start = 0;
        int end = length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Move to the right half if the target is greater than the middle element
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // Move to the left half if the target is smaller than the middle element
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Program is running");

        int evenArray[] = {2, 4, 6, 8, 12, 18};
        int length = evenArray.length;
        int target = 12;

        int oddArray[] = {3, 8, 11, 14, 16};

        int index = binarySearch(evenArray, length, target);
        System.out.println("Index of " + target + " is " + index);
    }
}
