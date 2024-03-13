package com.queue_program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class First_Negative_Integer_In_Window_K_Size {
	public static  ArrayList<Integer> printFirstNegativeInteger(Long[] a, int N, int K) {
		// creating the double ended queue for first 2 integer then for next 2
		Deque<Integer> queue = new ArrayDeque<>();
		// for storing the result

		ArrayList<Integer> list = new ArrayList<>();

		// for traverse through n size
		for (int i = 0; i < K; i++) {
			if (a[i] > 0) {
				queue.push(i);
			}
		}

		// store answer of K sized window

		if (queue.size() > 0) {
			long l = a[queue.removeFirst()];
			list.add((int) l);
		} else {
			list.add(0);
		}
		
		//processing for remaining windows
		for(int i =K;i<N;i++)
		{
			//removal
			if(queue.isEmpty() && i - queue.removeFirst()>= K)
			{
				queue.removeFirst();
			}
			
			//addition
			if(a[i] < 0)
			{
				queue.push(i);
			}
			
			//ans store
			
			if(queue.size() > 0)
			{
				long l = a[queue.removeFirst()];
				list.add((int) l);
			}else
			{
				list.add(0);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int N = 5;
		Long A[] = {-8L, 2L, 3L, -6L, 10L};
		int K =2;
		printFirstNegativeInteger(A,N,K);
	}
}
