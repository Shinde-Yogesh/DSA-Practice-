package com.recursion_program;

import java.util.ArrayList;

public class SubArray_With_given_Sum {

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		int starting = 0, ending = 0, sum = 0;
		while (ending < n) {
			if (sum == s) {
				ArrayList<Integer> res = new ArrayList<>();
				res.add(starting + 1);
				res.add(ending);
				return res;
			}
			if (sum < s) {
				if (ending < n) {
					sum += arr[ending];
					ending++;
				}
			} else {
				sum -= arr[starting];
				starting++;
			}
		}
		if (sum == s) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(starting + 1);
			res.add(ending);
			return res;
		}
		return new ArrayList<>(); // If no subarray is found
	}

	public static void sum_element(int index, ArrayList<Integer> list, int s, int sum, int array[], int n) {
		if (index == n) {
			if (s == sum) {
				for (Integer i : list) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			return;
		}
		list.add(array[index]);
		s += array[index];

		sum_element(index + 1, list, s, sum, array, n);

		s -= array[index];
		list.remove(list.size() - 1);

		sum_element(index + 1, list, s, sum, array, n);
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 7, 5 };
		int n = 5;
		int sum = 12;
//		System.out.println(subarraySum(A, n, sum));
		ArrayList<Integer> list = new ArrayList<>();
		sum_element(0, list, 0, sum, A, n);
	}

}

/*
 * 
 * Input: N = 5, S = 12 A[] = {1,2,3,7,5} Output: 2 4 Explanation: The sum of
 * elements from 2nd position to 4th position is 12.
 */