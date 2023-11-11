package com.recursion_program;

import java.util.ArrayList;

public class SubArray_With_given_Sum {
	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 7, 5 };
		int n = 5;
		int sum = 12;
		// System.out.println(subarraySum(A, n, s));
		ArrayList<Integer> list = new ArrayList<>();
		sum_element(0, list, 0, sum, A, n);
	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		int starting = 0, ending = 1, sum = arr[0];
		while (sum != s & starting != n) {
			sum += arr[ending];
			if (sum < s) {
				ending++;
			} else if (sum > s) {
				starting++;
				ending = starting + 1;
				sum = arr[starting];
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		res.add(starting + 1);
		res.add(ending + 1);
		return res;
	}

	public static void sum_element(int index, ArrayList<Integer> list, int s, int sum, int array[], int n) {
		if (index == n) {
			if (s == sum) {
				for (Integer i : list) {
					System.out.print(i + " ");
					System.out.println();
				}
				return;
			}
			list.add(array[index]);
			s += array[index];

			sum_element(index + 1, list, s, sum, array, n);

			s -= array[index];
			list.remove(array[index]);

			sum_element(index + 1, list, s, sum, array, n);
		}
	}

}

/*
 * 
 * Input: N = 5, S = 12 A[] = {1,2,3,7,5} Output: 2 4 Explanation: The sum of
 * elements from 2nd position to 4th position is 12.
 */