package com.binary_search;

public class FirstOccarance_And_LastOccarance {

    public static int firstOccurrence(int arr[], int size, int key) {
        int start = 0;
        int end = size - 1;
        int mid;
        int ans = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                ans = mid;
                end = mid - 1; // Move left to find the first occurrence
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static int lastOccurrence(int arr[], int size, int key) {
        int start = 0;
        int end = size - 1;
        int mid;
        int ans = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                ans = mid;
                start = mid + 1; // Move right to find the last occurrence
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 3, 3, 3, 3, 3, 5};
        int key = 3;

        int firstIndex = firstOccurrence(arr, arr.length, key);
        int lastIndex = lastOccurrence(arr, arr.length, key);

        System.out.println("The first occurrence of key " + key + " is at index " + firstIndex);
        System.out.println("The last occurrence of key " + key + " is at index " + lastIndex);
    }
}

/*			
    			Approach 2
    			
    			package com.binary_search;
				import java.util.Arrays;
				import java.util.OptionalInt;
				
				public class FirstAndLastOccurrence {
				
				    public static OptionalInt firstOccurrence(int[] arr, int key) {
				        return Arrays.stream(arr)
				                     .boxed()
				                     .filter(value -> value == key)
				                     .findFirst()
				                     .map(val -> Arrays.asList(arr).indexOf(val));
				    }
				
				    public static OptionalInt lastOccurrence(int[] arr, int key) {
				        return Arrays.stream(arr)
				                     .boxed()
				                     .filter(value -> value == key)
				                     .reduce((first, second) -> second)
				                     .map(val -> Arrays.asList(arr).lastIndexOf(val));
				    }
				
				    public static void main(String[] args) {
				        int[] arr = {1, 2, 3, 3, 3, 3, 3, 3, 3, 5};
				        int key = 3;
				
				        OptionalInt firstIndex = firstOccurrence(arr, key);
				        OptionalInt lastIndex = lastOccurrence(arr, key);
				
				        System.out.println("The first occurrence of key " + key + " is at index " + (firstIndex.isPresent() ? firstIndex.getAsInt() : -1));
				        System.out.println("The last occurrence of key " + key + " is at index " + (lastIndex.isPresent() ? lastIndex.getAsInt() : -1));
				    }
				}

   // This approach leverages Java 8's functional programming features to achieve the same goal as the binary search but in a more concise and expressive manner.
// OptionalInt is used to handle the possibility that the key might not be found in the array.
    			*/
