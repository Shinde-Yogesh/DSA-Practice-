package com.recursion_program.easy_Level;

import java.util.TreeSet;

public class Min_And_Max_Value {
	
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
	
	
	//new approch
	public static int findMinRec(int A[], int n) 
    { 
      // if size = 0 means whole array 
      // has been traversed 
      if(n == 1) 
        return A[0]; 
          
        return Math.min(A[n-1], findMinRec(A, n-1)); 
    } 
      
	public static int findMaxRec(int A[], int n) 
    { 
      // if size = 0 means whole array 
      // has been traversed 
      if(n == 1) 
        return A[0]; 
          
        return Math.max(A[n-1], findMaxRec(A, n-1)); 
    } 
    // Driver code 
    public static void main(String args[]) 
    { 
        int A[] = {1, 4, 3, -5, -4, 8, 6}; 
        int n = A.length; 
          
        // Function calling 
        		int min = (findMinRec(A, n)); 
        		int max = findMaxRec(A,n);
        		
        		System.out.println("the min: "+ min+" and max :"+ max);
    } 
}
/*
Input: arr = {1, 4, 3, -5, -4, 8, 6};
Output: min = -5, max = 8*/