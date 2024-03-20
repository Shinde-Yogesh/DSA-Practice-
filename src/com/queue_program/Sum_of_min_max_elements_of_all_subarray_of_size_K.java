package com.queue_program;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sum_of_min_max_elements_of_all_subarray_of_size_K {
	
	private static void solve(int[] array, int n,int k) {
		
		//create two doubly ended queue
		//for min and max store value between k size
		
		Deque<Integer> max = new ArrayDeque<>(k);
		Deque<Integer> min = new ArrayDeque<>(k);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		int array[] = { 2, -5, -1, 7, -3, -1, -2 };
		int n = array.length;
		int k = 4;
	solve(array,n,k);
	}

	
}
