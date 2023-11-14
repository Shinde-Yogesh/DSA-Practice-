package com.recursion_program.easy_Level;

import java.util.TreeSet;

public class Min_And_Max_Value {
	public static void main(String[] args) {
		long array[] = {1, 4, 3, -5, -4, 8, 6};
		int[] minMax = getMinMax(array);
		for (int i : minMax) {
			System.out.print(i+" ");
		}
	}
	

	static int[] getMinMax(long a[])  
    {
        
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(long i : a)
		{
		ts.add((int) i);	
		}
		int min = ts.pollFirst();
		int max= ts.pollLast();
		
        return new int[] {min,max};
    }
}
/*
Input: arr = {1, 4, 3, -5, -4, 8, 6};
Output: min = -5, max = 8*/