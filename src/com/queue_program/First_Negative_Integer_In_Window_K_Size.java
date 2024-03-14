package com.queue_program;

import java.io.IOException;
import java.util.ArrayDeque;

public class First_Negative_Integer_In_Window_K_Size {
/*
	public static long[] printFirstNegativeInteger(long[] a, int N, int K) {

		long arr[] = new long[N - K + 1];

		for (int i = 0; i < N - K + 1; i++) {
			for (int j = i; j < i + K; j++) {
				if (a[j] < 0) {
					arr[i] = a[j];
					break;
				}
			}
		}

		return arr;
	}
	
	public static void main(String[] args) throws IOException {
		int N = 5;
		long A[] = { -8, 2, 3, -6, 10 };
		int k = 2;
		long[] printFirstNegativeInteger = printFirstNegativeInteger(A, N, k);

		for (long l : printFirstNegativeInteger) {
			System.out.print(l + " ");
		}
	}
	*/
	
	/*
		
						Brute Force Approach:
				
					Iterates through each window of size k in the array.
					For each window, checks if there exists a negative element.
					If a negative element is found, it's stored as the result for that window.
					Time complexity is high (results in Time Limit Exceeded) due to nested loops and redundant iterations.
					  		
*/

	
			//Approach 2
	public static void printFirstNegative(int[] arr, int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        for (; i < k; i++) {
            if (arr[i] < 0)
                queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (; i <= n; i++) {
            if (!queue.isEmpty())
                sb.append(arr[queue.peek()]).append(" ");
            else
                sb.append("0 ");
            while (!queue.isEmpty() && queue.peek() < (i - k + 1)) {
                queue.remove();
            }
            if (i < n && arr[i] < 0)
                queue.add(i);
        }
        System.out.println(sb.toString().trim());
    }

	
	 public static void main(String[] args) {
	        int[] arr = {-8, 2, 3, -6, 10};
	        int n = arr.length;
	        int k = 2;
	        printFirstNegative(arr, n, k);
	    }
}
/*
 					Sure, let's break down the code step by step:

				1. **Method Definition:**
				    - We define a class `FirstNegativeInWindow` with a method `printFirstNegative`.
				    - This method takes three parameters: an array `arr`, its size `n`, and the window size `k`.
				
				2. **Initializing a Deque and Processing the First Window:**
				    - We create a `Deque` (double-ended queue) named `queue` to store indices of negative elements within the current window.
				    - We initialize a variable `i` to 0 and iterate from 0 to `k - 1`. During this iteration, we:
				        - Check if the element at index `i` is negative.
				        - If it's negative, we add the index `i` to the `queue`.
				
				3. **Iterating Through the Array:**
				    - We initialize a `StringBuilder` named `sb` to store the result.
				    - We continue the iteration from `k` to `n`, inclusive (i.e., until `i <= n`), 
				            where `i` represents the right boundary of the current window.
				    - Inside the loop, we:
				        - Check if the `queue` is not empty. If so, we append the value of `arr[queue.peek()]` (i.e., the first negative integer in the window) to the `StringBuilder`.
				         If the `queue` is empty, it means there's no negative integer in the current window, so we append "0" to the `StringBuilder`.
				        - Then, we remove elements from the `queue` that are no longer within the current window (indices less than `i - k + 1`).
				        - Check if `i` is within the array bounds and if the element at index `i` is negative. If both conditions are met, we add the index `i` to the `queue`.
				        
				4. **Printing the Result:**
				    - After the loop ends, we print the result stored in the `StringBuilder`, trimming any leading or trailing whitespace.
				
				5. **Main Method:**
				    - In the `main` method, we define the input array `arr`, its size `n`, and the window size `k`.
				    - We call the `printFirstNegative` method with these parameters to find the first negative integer for each window of size `k`.
				 		
 		
 		*/
