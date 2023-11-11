package com.binary_search;

public class Pivot_Element {
	public static int getPivot(int array[], int n)
	{
		int s = 0;
		int e  = n-1;
		int mid = s + (e-s)/2;
		
		while(s<e)
		{
			if(array[mid] >= array[0])
			{
				s = mid+1;
			}
			else {
				e = mid;
			}
			mid = s + (e-s)/2;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int array[] = {8, 10, 17, 1, 3};
		
		System.out.println("Pivot element is "+ getPivot(array, array.length));
	}

}
