package com.queue_program;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sum_of_min_max_elements_of_all_subarray_of_size_K {
	
	private static int solve(int[] array, int n,int k) {
		
		//create two doubly ended queue
		//for min and max store value between k size
		
		Deque<Integer> max = new ArrayDeque<>(k);
		
		
		Deque<Integer> min = new ArrayDeque<>(k);
		System.out.println("The smallest element in Dequeue : "+ min);
		
		//Addition first k size window
		for(int i = 0; i<k;i++)
		{
			
			//check base case max is not empty 
			// and store the max of index 
			//after get the actual value using array and stored index 
			
			while(!max.isEmpty() &&  array[(max.getLast())] <= array[i])
			{
				max.removeLast(); //remove last
			}
			
			while(!min.isEmpty() && array[min.getLast()]  >= array[i])
			{
				min.removeLast();
			}
			
			max.addLast(i);
			min.addLast(i);
			System.out.println("The max element in Dequeue : "+ max);
			System.out.println("The smallest element in Dequeue : "+ min);
		}
		int ans = 0;
		for(int i = k; i<n;i++)
		{
			ans += array[max.getFirst()] + array[min.getFirst()];
			
			//next window
			
			//removal
			while(!max.isEmpty() && i - max.getFirst() >= k)
			{
				max.removeFirst();
			}
			
			//removal
			while(!min.isEmpty() && i - min.getFirst() >= k)
			{
				min.removeFirst();
			}
			
			
			//Addition
			
			while(!max.isEmpty() &&  array[(max.getLast())] <= array[i])
			{
				max.removeLast();
			}
			
			while(!min.isEmpty() && array[min.getLast()]  >= array[i])
			{
				min.removeLast() ;
			}
			
			max.addLast(i);
			min.addLast(i);
		}
		
		//last window
		ans += array[max.getFirst()] + array[min.getFirst()];
		return ans;
	}	
	
	public static void main(String[] args) {
		int array[] = { 2, 5, -1, 7, -3, -1, -2 };
		int n = array.length;
		int k = 4;
	System.out.println(solve(array,n,k));
	}

	
}
