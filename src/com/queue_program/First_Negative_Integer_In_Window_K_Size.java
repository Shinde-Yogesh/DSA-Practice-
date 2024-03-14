package com.queue_program;

import java.io.IOException;

public class First_Negative_Integer_In_Window_K_Size {

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
}
/*
  		
  					Brute Force Approach:

					Iterates through each window of size k in the array.
					For each window, checks if there exists a negative element.
					If a negative element is found, it's stored as the result for that window.
					Time complexity is high (results in Time Limit Exceeded) due to nested loops and redundant iterations.
					  		
  		*/
